class Dummy{
    private void foo(){
        System.out.println("hello foo()");
    }
    private int i = 10;
}

class Test{
    public static void main(String[] args) throws Exception {
        Dummy d = new Dummy();

        /*---  [INVOKING PRIVATE METHOD]  ---*/
        Method m = Dummy.class.getDeclaredMethod("foo");
        //m.invoke(d); // Exception java.lang.IllegalAccessException
        m.setAccessible(true);//Abracadabra
        m.invoke(d); // Now it's OK

        /*---  [GETING VALUE FROM PRIVATE FIELD]  ---*/
        Field f = Dummy.class.getDeclaredField("i");
        //System.out.println(f.get(d)); // Not accessible now
        f.setAccessible(true); // Abracadabra
        System.out.println(f.get(d)); // Now it's OK

        /*---  [SETTING VALUE OF PRIVATE FIELD]  ---*/
        Field f2 = Dummy.class.getDeclaredField("i");
        //f2.set(d,20); // Not accessible now
        f2.setAccessible(true); // Abracadabra
        f2.set(d, 20); // Now it's OK
        System.out.println(f2.get(d));
    }
}