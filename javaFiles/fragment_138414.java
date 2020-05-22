interface Calculator {
    void setA(int a);
    void setB(int b);
    int compute();
}
class Adder implements Calculator {
    private int a,b;
    public void setA(int a) {this.a=a;}
    public void setB(int b) {this.b=b;}
    public int compute() {return a+b;}
}
class Multiplier implements Calculator {
    private int a,b;
    public void setA(int a) {this.a=a;}
    public void setB(int b) {this.b=b;}
    public int compute() {return a*b;}
}
class Test {
    static <T extends Calculator> void computeWithClass(Class<T> calcClass)
    throws Exception {
         Calculator calc = calcClass.newInstance();
         calc.setA(123);
         calc.setB(321);
         System.out.println(calc.compute());
    }
    public static void main(String[] args) throws Exception {
        computeWithClass(Adder.class);
        computeWithClass(Multiplier.class);
    }
}