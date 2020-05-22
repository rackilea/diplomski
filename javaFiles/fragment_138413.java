interface Calculator {
    void setA(int a);
    void setB(int b);
    int compute();
    Calculator copy();
}
class Adder implements Calculator {
    private int a,b;
    public void setA(int a) {this.a=a;}
    public void setB(int b) {this.b=b;}
    public int compute() {return a+b;}
    public Calculator copy() {
        Adder res = new Adder();
        res.a = a;
        res.b = b;
        return res;
    }
}
class Multiplier implements Calculator {
    private int a,b;
    public void setA(int a) {this.a=a;}
    public void setB(int b) {this.b=b;}
    public int compute() {return a*b;}
    public Calculator copy() {
        Multiplier res = new Multiplier();
        res.a = a;
        res.b = b;
        return res;
    }
}
class Test {
    static void computeWithPrototype(Calculator proto) {
         Calculator calc = proto.copy();
         calc.setA(123);
         calc.setB(321);
         System.out.println(calc.compute());
    }
    public static void main(String[] args) throws Exception {
        computeWithPrototype(new Adder());
        computeWithPrototype(new Multiplier());
    }
}