public class Demo
{
    public static StringBuffer sBuffer;

    public static void appendString(String str)
    {
        sBuffer.append(str);
    }

    public static void main(String[] args) throws Exception
    {
        sBuffer = new StringBuffer(" test");
        appendString(" adding this");
        System.out.print(sBuffer);
    }
}