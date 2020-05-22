/**
 * Utility class to perform Freemarker template expansion.
 * 
 * @author Chris Mepham
 */
public class FreemarkerTemplateExpander implements ApplicationAware {

    static final String INCLUDE_REGEX = "<#include \\\"\\S+\\\"\\/>";

    static final String PATH_REGEX = "\\\"\\S+\\\"";

    private ModuleStateHolder moduleStateHolder;

    /**
     * Takes the Freemarker template String input and
     * 
     * recursively expands all of the includes.
     * 
     * @param input The String value of a Freemarker template.
     * 
     * @return The expanded version of the Freemarker template.
     */
    public final String expand(String module, String path, String input) {

        Assert.notNull(module, "module cannot be null");
        Assert.notNull(path, "path cannot be null");
        Assert.notNull(input, "input cannot be null");

        if (!hasText(input)) return input;

        // See if there is an include
        int indexOfNextInclude = getIndexOfNextInclude(Pattern.compile(INCLUDE_REGEX), input);

        // If there is no include just return the input text
        if (indexOfNextInclude == -1) return input;

        StringBuffer buffer = new StringBuffer();

        // Otherwise, get all the text up to the next include and add it to buffer
        String prefix = input.substring(0, indexOfNextInclude);
        if (hasText(prefix)) buffer.append(prefix);

        // Then get the contents of the include as a String
        String includeContents = getIncludeContents(module, path, input);
        if (hasText(includeContents)) buffer.append(includeContents);

        // Then get all the text after the next include
        int includeLastCharacterIndex = indexOfNextInclude + matchRegexPattern(input, INCLUDE_REGEX).length();

        String suffix = input.substring(includeLastCharacterIndex + 1);

        buffer.append(suffix);

        input = buffer.toString();

        return expand(module, path, input);
    }

    final String getIncludeContents(String module, String path1, String input) {

        // Get next include file relative path
        String nextIncludePath = getNextIncludePath(input);
        String resourcePath = getResourcePath(nextIncludePath);

        // Get file name
        String filename = getFilename(nextIncludePath);

        // Get file contents here
        String path = "templates." + resourcePath;
        InputStream resource = ClasspathResourceUtils.getClassPathResource(path, filename, getClassLoader(module));

        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(resource, writer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    static final int getIndexOfNextInclude(Pattern pattern, String input) {

        Matcher matcher = pattern.matcher(input);

        return matcher.find() ? matcher.start() : -1;
    }

    private static final String getNextIncludePath(String input) {

        String include = matchRegexPattern(input, INCLUDE_REGEX);

        if (include == null) return null;

        String path = matchRegexPattern(include, PATH_REGEX);
        path = path.replace("\"", "");

        return path;
    }

    private static final String matchRegexPattern(String input, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {

            return matcher.group(0);
        }

        return null;
    }

    private String getResourcePath(String path) {

        if (!path.contains("/")) return path;

        String resourcePath = path.substring(path.indexOf("/") + 1, path.lastIndexOf("/"));

        return resourcePath;

    }

    private String getFilename(String path) {

        if (!path.contains("/")) return path;

        return path.substring(path.lastIndexOf("/") + 1);
    }
}