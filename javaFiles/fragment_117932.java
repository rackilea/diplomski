import java.util.*;

public enum Foo
{
    BAR, BAZ;

    private static final Map<String, Foo> lowerCaseMap;

    static
    {
        lowerCaseMap = new HashMap<String, Foo>();
        for (Foo foo : EnumSet.allOf(Foo.class))
        {
            // Yes, use some appropriate locale in production code :)
            lowerCaseMap.put(foo.name().toLowerCase(), foo);
        }
    }
}