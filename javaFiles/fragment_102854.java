public class Child extends Parent{
    static String MY_CONSTANT = "hello world";

    @Override
    public void printSomething() {
        //MY_CONSTANT is hidden and has "hello world"
        super.printSomething(MY_CONSTANT); 
    }
}