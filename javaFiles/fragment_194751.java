//does not work
class YourClass
{
    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
    {
        CallingMethod cm = new CallingMethod();
        First1 f = new First1();
        // Method m = First1.class.getDeclaredMethod("show");
        Method m = First1.class.getMethod("show");
        m.invoke(f);
                    //output: You are in first class
        m.invoke(cm);
                    //output: You are in the third class
    }

}