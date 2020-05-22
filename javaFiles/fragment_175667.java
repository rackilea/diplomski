public class Example {
    private int value; 
    public Example () {
    }
    public final int getValue () {
        return value;
    } 
    public final void setValue (int value) throws IllegalArgumentException { 
        if (value < 0 || value > 10)
            throw new IllegalArgumentException("Value is out of range.");
    }
}