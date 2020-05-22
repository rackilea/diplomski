class interface operations { public int doSomething(int a, int b) {} }

public class test {
    public static void main(...) {
    operations[] ops = new operations[4];
    ops[0] = new operations() {public int doSomething(int a, int b) {return a-b*a;}};
...etc.
}