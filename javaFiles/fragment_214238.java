import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.bitbucket.cowwoc.preconditions.Preconditions;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ExtendedResourceContext;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.uri.PathPattern;
import org.glassfish.jersey.uri.UriComponent;
import org.glassfish.jersey.uri.UriTemplate;

[...]

/**
 * Returns the resource associated with a URI.
 * <p/>
 * WARNING: The input URI must be encoded according to the rule of {@link Path#value}.
 * <p/>
 * @param <T>  the resource type
 * @param uri  the encoded URI
 * @param type the resource type to return
 * @return the resource associated with the URI
 * @throws NullPointerException     if uri or type are null
 * @throws IllegalArgumentException if the URI does not map to this resource type
 * @throws ProcessingException      if an exception occurs while creating the resource
 */
public <T> T getByUri(URI uri, Class<T> type)
    throws NullPointerException, IllegalArgumentException, ProcessingException
{
    Preconditions.requireThat(uri, "uri").isNotNull();
    Preconditions.requireThat(type, "type").isNotNull();
    UriInfo uriInfo = serviceLocator.getService(UriInfo.class);
    ExtendedResourceContext resourceContext = serviceLocator.
        getService(ExtendedResourceContext.class);

    if (uriInfo.getBaseUri().relativize(uri).normalize().getPath().startsWith(".."))
    {
        throw new IllegalArgumentException("The uri did not originate from this server: " + uri +
            ". The expected base URI is: " + uriInfo.getBaseUri());
    }
    String path = uri.getRawPath();
    Resource match = findMatchingResource(resourceContext.getResourceModel().getRootResources(),
        path);
    if (match == null)
        throw new IllegalArgumentException(uri + " did not match any registered resource");
    Class<?> matchedType = getType(match);
    if (!type.isAssignableFrom(matchedType))
    {
        throw new IllegalArgumentException(uri + " is not of type " + type + ". It is of type: " +
            matchedType);
    }
    @SuppressWarnings("unchecked")
    T result = (T) createResource(match, path);
    return result;
}

/**
 * Returns the resource or sub-resource that matches a path segment.
 * <p>
 * @param resources a list of candidate resources
 * @param path      a path segment
 * @return null if no match is found
 * @throws NullPointerException if resources or path are null
 */
private Resource findMatchingResource(List<Resource> resources, String path)
    throws NullPointerException
{
    for (Resource resource: resources)
    {
        PathPattern pattern = resource.getPathPattern();
        MatchResult matcher = pattern.match(path);
        if (matcher == null)
            continue;
        assert (matcher.groupCount() >= 1): "resource: " + resource + ", path: " +
            resource.getPath() + ", match: " + matcher;

        // The segment not consumed by the parent resource
        String remaining = matcher.group(matcher.groupCount());
        if (remaining != null)
            remaining = remaining.trim();
        if (remaining == null || remaining.isEmpty() || remaining.equals("/"))
            return resource;
        Resource descendant = findMatchingResource(resource.getChildResources(), remaining);
        if (descendant != null)
            return descendant;
    }
    return null;
}

/**
 * @param resource a resource
 * @return the user class the resource references
 * @throws NullPointerException resource is null
 */
private Class<?> getType(Resource resource) throws NullPointerException
{
    try
    {
        ResourceMethod resourceLocator = resource.getResourceLocator();
        if (resourceLocator != null)
            return (Class<?>) resourceLocator.getInvocable().getResponseType();
        for (String name: resource.getNames())
        {
            // ASSUMPTION: Merged resource models contain only one JAX-RS resource class.
            // Other resource models (e.g. corresponding to subresource methods) are named: "[unnamed]".
            if (name.isEmpty() || !Character.isAlphabetic(name.charAt(0)))
                continue;
            return Class.forName(name, true, getClass().getClassLoader());
        }
        throw new AssertionError("Resources must have at least one name: " + resource);
    }
    catch (ClassNotFoundException e)
    {
        // ASSUMPTION: The metadata cannot exist unless the class was already loaded by the ClassLoader.
        throw new AssertionError(e);
    }
}

/**
 * Creates the resource associated with a URI path.
 * <p>
 * @param resource the resource type
 * @param path     the URI path
 * @return the resource
 * @throws NullPointerException     if resource or path are null
 * @throws IllegalArgumentException if the URI does not map to this resource type
 * @throws ProcessingException      if an exception occurs while creating the resource
 */
private Object createResource(Resource resource, String path)
    throws NullPointerException, IllegalArgumentException, ProcessingException
{
    List<Resource> resourceTree = getAncestorTree(resource);

    // Process the root of the tree
    Resource rootResource = resourceTree.get(0);
    Object parentResource = serviceLocator.getService(getType(rootResource));
    if (resourceTree.size() == 1)
        return parentResource;
    // The path segment not matched by the root
    String remaining = getRemainingPath(rootResource, path);

    // Process the rest of the tree
    for (Resource currentResource: resourceTree.subList(1, resourceTree.size()))
    {
        List<String> stringArguments = getStringArguments(currentResource, remaining);
        remaining = getRemainingPath(currentResource, remaining);

        Method resourceLocator = currentResource.getResourceLocator().getInvocable().
            getHandlingMethod();

        // Convert the resource locator arguments from String to the expected type
        Class<?>[] parameterTypes = resourceLocator.getParameterTypes();
        Object[] arguments = new Object[parameterTypes.length];
        for (int i = 0, size = stringArguments.size(); i < size; ++i)
        {
            Class<?> expectedType = parameterTypes[i];
            arguments[i] = parse(stringArguments.get(i), expectedType);
        }

        // Invoke the resource locator
        try
        {
            parentResource = resourceLocator.invoke(parentResource, arguments);
        }
        catch (ReflectiveOperationException e)
        {
            throw new ProcessingException(e);
        }
    }
    return parentResource;
}

/**
 * @param resource a resource
 * @param path     a path segment matched by the resource
 * @return the path segment not consumed by the resource
 */
private String getRemainingPath(Resource resource, String path)
{
    MatchResult matcher = resource.getPathPattern().match(path);
    assert (matcher.groupCount() >= 1): "resource: " + resource + ", path: " + resource.getPath() +
        ", match: " + matcher;

    // The remaining path (not consumed by the parent resource)
    return matcher.group(matcher.groupCount());
}

/**
 * @param method a resource locator
 * @param path   the path segment that the method matched
 * @return a list of the string arguments passed into the method
 */
private List<String> getStringArguments(Resource resource, String path)
{
    // Parse the URI into template key-value pairs
    MatchResult match = resource.getPathPattern().match(path);
    List<String> templateKeys = resource.getPathPattern().getTemplate().getTemplateVariables();
    Map<String, String> template = new HashMap<>((int) Math.ceil(templateKeys.size() / 0.75));
    List<Integer> groupNumbers = getGroupNumbers(resource.getPathPattern());
    for (int i = 0, size = templateKeys.size(); i < size; ++i)
        template.put(templateKeys.get(i), match.group(groupNumbers.get(i)));

    Method resourceLocator = resource.getResourceLocator().getInvocable().getHandlingMethod();
    List<String> result = new ArrayList<>(resourceLocator.getParameters().length);
    for (Parameter parameter: resourceLocator.getParameters())
    {
        PathParam annotation = parameter.getAnnotation(PathParam.class);
        if (annotation == null)
            continue;
        String key = annotation.value();
        String value = template.get(key);
        result.add(UriComponent.decode(value, UriComponent.Type.PATH));
    }
    return result;
}

/**
 * @param pattern a PathPattern
 * @return the group numbers of the top-level capturing groups
 */
private List<Integer> getGroupNumbers(PathPattern pattern)
{
    int[] candidate = pattern.getGroupIndexes();
    if (candidate.length > 0)
        return Ints.asList((int[]) candidate);
    UriTemplate template = pattern.getTemplate();
    List<Integer> result = new ArrayList<>(template.getTemplateVariables().size());
    String regex = template.getPattern().getRegex();

    // Find an unescaped open or close brace
    Matcher braces = Pattern.compile("[^\\\\](\\(|\\))").matcher(regex);
    int level = 0;
    int groupNumber = 1;
    while (braces.find())
    {
        switch (braces.group(1))
        {
            case "(":
            {
                if (level == 0)
                    result.add(groupNumber);
                ++groupNumber;
                ++level;
                break;
            }
            case ")":
            {
                --level;
                assert (level >= 0): regex;
                break;
            }
            default:
                throw new AssertionError("Unexpected character: " + braces.group(1));
        }
    }
    return result;
}

/**
 * @param resource a resource
 * @return a list of resources, from the top-most ancestor down to the resource itself
 * @throws NullPointerException resource is null
 */
private List<Resource> getAncestorTree(Resource resource)
    throws NullPointerException
{
    List<Resource> result = new ArrayList<>(10);
    Resource current = resource;
    do
    {
        result.add(current);
        current = current.getParent();
    }
    while (current != null);
    Collections.reverse(result);
    return result;
}

/**
 * Converts a String to a different type.
 * <p>
 * @param value the string value
 * @param type  the desired type
 * @return the parsed value
 */
private Object parse(String value, Class<?> type)
{
    // PERFORMANCE: Because the small number of entries, it's faster to do a linear search than
    // using a HashMap. Testing under Java 8.
    if (type.isAssignableFrom(String.class))
        return value;
    if (type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class))
        return Boolean.valueOf(value);
    if (type.isAssignableFrom(char.class) || type.isAssignableFrom(Character.class))
    {
        if (value.length() != 0)
            throw new ProcessingException("Expecting a single character. Got: \"" + value + "\"");
        return value.charAt(0);
    }
    if (type.isAssignableFrom(byte.class) || type.isAssignableFrom(Byte.class))
        return Byte.valueOf(value);
    if (type.isAssignableFrom(short.class) || type.isAssignableFrom(Short.class))
        return Short.valueOf(value);
    if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class))
        return Integer.valueOf(value);
    if (type.isAssignableFrom(long.class) || type.isAssignableFrom(Long.class))
        return Long.valueOf(value);
    if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class))
        return Float.valueOf(value);
    if (type.isAssignableFrom(double.class) || type.isAssignableFrom(Double.class))
        return Double.valueOf(value);
    throw new AssertionError("Unexpected type: " + type);
}