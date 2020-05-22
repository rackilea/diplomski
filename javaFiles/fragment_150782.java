public class DemoClass {
    // Overloaded method
    public Integer sum(Integer a, Integer b) throws NullPointerException{
        return a + b;
    }

    // Overloading method
    public Integer sum(Integer a, Integer b) throws Exception{  //Not valid; Compile time error
        return null;
    }
}