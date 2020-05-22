public class MySet extends HashSet<MySet.MyClass> {
    public static class MyClass {}

    public static class MySubClass extends MyClass {}

    @Override
    public boolean add(MyClass c) {
        if (c.getClass() != MyClass.class) {
            throw new IllegalArgumentException("illegal class to add " + c.getClass().getName());
        }
        return super.add(c);
    }

    public static void main(String[] args) {
        MySet set = new MySet();
        set.add(new MyClass());   // works
        set.add(new MySubClass()); // throws Exception
    }

}