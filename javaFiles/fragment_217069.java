public class Child extends Parent {
    private String test;

    @Override
    public void ontest() {
        test = "tryyyysssssssssss";
        System.out.println("in constructer: " + test);
    }

    @Override
    public String gettt() {
        System.out.println("in child: " + test);
        return test;
    }

    public static void main(String[] args) {
        Child s = new Child();
        System.out.println("vaaaa:" + s.gettt());
    }

}

abstract class Parent {
    Parent() {
        ontest();
    }

    public abstract void ontest();

    public String get() {
        return gettt();
    }

    public abstract String gettt();
}