public class ExampleClass {

    public static final Class<?>[] classes = new Class[]{MyClass1.class,
        MyClass2.class, MyClass3.class, MyClass4.class, MyClass5.class};

    public void myMethod() {
        for (Class<?> c : DataBaseConfigUtils.classes ) {
            act(c);    
        }
    }

    private <T> void act(Class<T> c) {
        MyObjectDAO<T, Integer> myObjectDAO = getMyObjectDAO(c);
        ArrayList<T> list = myObjectDAO.queryAll();
        for (T element : list) {
            processElement(element);
        }
    }

    public <T> MyObjectDAO<T, Integer> getMyObjectDAO(Class<T> c) {
        return doSomething(c);
    }
}