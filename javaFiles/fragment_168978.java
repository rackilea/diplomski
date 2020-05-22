import java.lang.reflect.*;

public class Main
{
    static Field stringBackingField = null;

    public static void main(String[] args) throws Exception
    {
        String strA = "1234567890";
        String strB = "1234567890";
        char[] charA = getBackingArray(strA);
        char[] charB = getBackingArray(strB);
        char[] subA1 = getBackingArray(strA.substring(1));
        char[] subA2 = getBackingArray(strA.substring(0, 9));
        System.out.println("charA address: " + System.identityHashCode(charA));
        System.out.println("charB address: " + System.identityHashCode(charB));
        System.out.println("subA1 address: " + System.identityHashCode(subA1));
        System.out.println("subA2 address: " + System.identityHashCode(subA2));
        System.out.println("charA == charB: " + (charA == charB));
        System.out.println("charA == subA1: " + (charA == subA1));
        System.out.println("charA == subA2: " + (charA == subA2));
    }

    public static char[] getBackingArray(String s) throws Exception
    {
        if (stringBackingField == null)
        {
            stringBackingField = String.class.getDeclaredField("value");
            stringBackingField.setAccessible(true);
        }
        return (char[]) stringBackingField.get(s);
    }
}