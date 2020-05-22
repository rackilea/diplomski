import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum MyEnumClass
{
    ENUM_1, ENUM_2, ENUM_3, ENUM_4, ENUM_5;

    public static void main(String[] args)
    {
        for (String string : getEnumString(MyEnumClass.class))
            System.out.println(string);
    }

    public static <E extends Enum<E>> List<String>
            getEnumString(Class<E> eClass)
    {
        List<String> returnList = new ArrayList<String>();

        for (E en : EnumSet.allOf(eClass))
        {
            returnList.add(en.name());
        }

        return returnList;
    }
}