import java.io.Serializable;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows properties to contain expansions of the form ${propertyName}. This
 * class makes no attempt to detect circular references, so be careful.
 */
public class ExpandingProperties extends Properties implements PropertySource {

    private static final long serialVersionUID = 259782782423517925L;
    private final Expander expander = new Expander();

    @Override
    public String getProperty(String key) {
        return expander.expand(super.getProperty(key), this);
    }
}

class Expander implements Serializable {

    private static final long serialVersionUID = -2229337918353092460L;
    private final Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");

    /**
     * Expands variables of the form "${variableName}" within the
     * specified string, using the property source to lookup the
     * relevant value.
     */
    public String expand(final String s, final PropertySource propertySource) {
        if (s == null) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        final Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            final String variableName = matcher.group(1);
            final String value = propertySource.getProperty(variableName);
            if (value == null) {
                throw new RuntimeException("No property found for: " + variableName);
            }
            matcher.appendReplacement(sb, value.replace("$", "\\$"));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}

interface PropertySource {

    String getProperty(String key);
}