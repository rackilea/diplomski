public class DemoClass {
    // Overloaded method
    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    // Overloading method
    public Float sum(Integer a, Integer b) {     //Not valid; Compile time error
        return null;
    }
}