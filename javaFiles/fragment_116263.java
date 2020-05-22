public class Engine 
{
    private static final MyObject OBJ1;
    private static final MyObject OBJ2;

    static
    {
        OBJ1 = new MyObject1();
        OBJ2 = new MyObject2();
    }

    public MyObject getObj(final int param)
    {
        switch (param)
        {
            case 1:
                return Engine.OBJ1;
            case 2:
                return Engine.OBJ2;
            default:
                throw new IllegalArgumentException(String.format("%d is not a valid object id", param));
        }
    }

    public static class MyObject1 implements MyObject { private MyObject1() {} } 
    public static class MyObject2 implements MyObject { private MyObject2() {} } 

}