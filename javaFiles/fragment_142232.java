class Test {

    int i;

    public static void main(String[] args) throws Exception {
        Class c = Test.class;
        Field f1 = c.getDeclaredField("i");
        Field f2 = c.getDeclaredField("i");
        System.out.println(f1 == f2); //prints false
    }
}