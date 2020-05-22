public class MyClass {
    private static MyClass trueObject = null;

    public void setProperty(boolean value) {
        if (value) {
            trueObject = this;
        } else {
            trueObject = null;
        }
    }

    public boolean getProperty() {
        return trueObject == this;
    }
}