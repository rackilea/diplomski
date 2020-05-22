public class CheckTest
{
    public static final void main(String[] params)
    {
        new CheckTest().method2();
    }

    public void method1() throws Exception{
        throw new java.text.ParseException("foo", 2);
    }

    public void method2() throws Exception{
        this.method1();
    }
}