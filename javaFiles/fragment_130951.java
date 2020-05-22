import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DecodeUrl
{
    public static void main(String[] args)
    {
        String s = "foo[bar]=value&foo[bar1][baz1]=1&foo[bar1][baz2]=2&foo[bar2][]=3&foo[bar2][]=4";
        Map<String, Object> result = decode(s);
        print(result, "");
    }

    private static void print(Map<?, ?> map, String indent)
    {
        for (Entry<?, ?> entry : map.entrySet())
        {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map<?, ?>)
            {
                Map<?, ?> next = (Map<?, ?>) value;
                System.out.println(indent + key + " : ");
                print(next, indent + "  ");
            } 
            else
            {
                System.out.println(indent + key + " : " + value 
                    + " (type " + value.getClass().getSimpleName() + ")");
            }
        }
    }

    private static Map<String, Object> decode(String s)
    {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        String tokens[] = s.split("&");
        for (String token : tokens)
        {
            int equalsIndex = token.indexOf('=');
            String key = token.substring(0, equalsIndex);
            String valueString = token.substring(equalsIndex+1);
            Object value = processValue(valueString);
            add(result, tokenize(key), value);
        }
        return result;
    }


    private static void add(
        Map<String, Object> target, List<String> path, Object value)
    {
        if (path.size() == 2)
        {
            String parentName = path.get(0);
            String propertyName = path.get(1);
            if (propertyName.isEmpty())
            {
                List<Object> list = getList(target, parentName);;
                list.add(value);
            }
            else
            {
                Map<String, Object> map = getMap(target, parentName);
                map.put(propertyName, value);
            }
        }
        else
        {
            String propertyName = path.get(0);
            Map<String, Object> map = getMap(target, propertyName);
            target.put(propertyName, map);
            add(map, path.subList(1, path.size()), value);
        }
    }

    private static List<Object> getList(
        Map<String, Object> map, String name)
    {
        Object object = map.computeIfAbsent(name, 
            e -> new ArrayList<Object>());
        @SuppressWarnings("unchecked")
        List<Object> result = (List<Object>) object;
        return result;
    }


    private static Map<String, Object> getMap(
        Map<String, Object> map, String name)
    {
        Object object = map.computeIfAbsent(name, 
            e -> new LinkedHashMap<String, Object>());
        @SuppressWarnings("unchecked")
        Map<String, Object> result = (Map<String, Object>) object;
        return result;
    }


    private static List<String> tokenize(String key)
    {
        String s = key.replaceAll("\\[", ".");
        String t = s.replaceAll("\\]", "");
        return Arrays.asList(t.split("\\.", -1));
    }

    private static Object processValue(String valueString)
    {
        Long longValue = asLong(valueString);
        if (longValue != null)
        {
            return longValue;
        }
        Double doubleValue = asDouble(valueString);
        if (doubleValue != null)
        {
            return doubleValue;
        }
        return valueString;
    }

    private static Long asLong(String string)
    {
        try
        {
            return Long.parseLong(string);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    private static Double asDouble(String string)
    {
        try
        {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }
}