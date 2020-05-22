public class MyClass {
    private final float variable;

    public MyClass(float variable) {
        this();
        if(variable < 0.0f || 1.0f < variable)
            throw new IllegalArgumentException("'variable' has to be between 0.0 and 1.0");
        this.variable = variable;
    }

    private MyClass() {
        //Set everything else
    }
}