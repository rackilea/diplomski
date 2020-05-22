public class Test
{
    public static void main(String[] args)
    {
        byte bar = -128;
        int tmp = (bar & ((byte)-64)) >>> 6;
        byte foo = (byte)tmp;
        System.out.println(tmp);
        System.out.println(foo);
    }
}