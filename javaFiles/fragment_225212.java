class Outer {
    private String name;
    public Outer(String name) { this.name = name; }
    public String getName() { return name; }

    class Inner{}
}

class Demo {

    public static void main(String[] args) throws Exception {

        Outer o1 = new Outer("foo");
        Outer o2 = new Outer("bar");

        Inner i1 = o1.new Inner();
        Inner i2 = o2.new Inner();

        System.out.println(((Outer) getOuterInstance(i1)).getName());
        System.out.println(((Outer) getOuterInstance(i2)).getName());

    }

    public static Object getOuterInstance(Object inner)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {

        Class<?> clazz = inner.getClass();
        Field f = clazz.getDeclaredField("this$0");
        f.setAccessible(true);

        return f.get(inner);
    }

}