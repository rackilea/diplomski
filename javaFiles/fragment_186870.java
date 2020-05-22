import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsReplacer
{
    private static Pattern lookupPattern = Pattern.compile("\\$\\{([^\\}]+)\\}");

    public static String replaceString(String input, Map<String, Object> context)
        throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        int position = 0;
        StringBuffer result = new StringBuffer();

        Matcher m = lookupPattern.matcher(input);
        while (m.find())
        {
            result.append(input.substring(position, m.start()));
            result.append(BeanUtils.getNestedProperty(context, m.group(1)));
            position = m.end();
        }

        if (position == 0)
        {
            return input;
        }
        else
        {
            result.append(input.substring(position));
            return result.toString();
        }
    }
}