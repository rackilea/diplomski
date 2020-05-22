public class MyVariableWrapper {
    public static volatile int some_var = 9;
    public void updateSomeVar(int newvar) {
         some_var = newvar;
    }
    public int getSomeVar() { return some_var; }
}