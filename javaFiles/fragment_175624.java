public class MyClass {

    // Non-static field
    private int value;
    public static int otherValue;

    // Constructor
    public MyClass(int value, int otherValue) { 
        this.value = value;
        MyClass.otherValue = otherValue;
    }

    private void increaseValuesButton(java.awt.event.ActionEvent evt) {
        value++; // Works just fine
        MyClass.otherValue++; // Also works fine
    }

}