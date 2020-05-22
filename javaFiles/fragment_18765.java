public class MyClass {
    public void doSomething(int value) {
        PrintWriter fileOP = new PrintWriter("file.txt");
        this.recursiveFn(value,fileOP);
    }
    public void recursiveFn(int value,PrintWriter fileOp) {
         int a = value + 1; // Or whatever
         recursiveFn(a,fileOp);
         fileOp.printf(somevaluefromthisfunction);
    }
}