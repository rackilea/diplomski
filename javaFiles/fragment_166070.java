public class ExampleClass {
    private final int counter;

    public ExampleClass(int counter) {
        this.counter = counter;
    }
}

...

ExampleClass[] array = new ExampleClass[7];
for (int i = 0; i < array.length; i++) {
    array[i] = new ExampleClass(i);
}