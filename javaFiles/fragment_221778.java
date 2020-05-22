package aaa;

public class Test1 {
    private static class TestObserver implements SomethingChangedListener {
        @Override public void somethingChanged(String name, Object newValue) {
            System.out.println("Property '" + name + "' changed to '" + newValue + "'");
        }
    }
    public static void main(String[] args) {
        Person p = new Person();
        p.addSomethingChangedListener(new TestObserver());
        p.setName("Scott");
        p.setAge(43);
    }
}