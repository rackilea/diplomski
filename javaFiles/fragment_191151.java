public class ExampleClass {
    public static void main(String[] args) {

        ExampleClass exampleClass = new ExampleClass();
        exampleClass.exampleMethod();
    }

    public void exampleMethod() {
        String string = "This is an example";
        for (int counter = 0; counter < 10; counter++) {
            String localResult = string + counter;
            System.out.println(localResult);
        }
    }
}