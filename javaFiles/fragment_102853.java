public class Parent {
    static String MY_CONSTANT = "bla bla";

    public void printSomething(String something) {
        System.out.println(something);
    }

    //Essentially, Parent.MY_CONSTANT becomes just the default
    public void printSomething() {
        System.out.println(MY_CONSTANT);
    }
}