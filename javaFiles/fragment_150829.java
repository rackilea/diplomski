public class A {
    private MyInterface b;
    public A(MyInterface b){
      this.b = b;
    }
    public T doSth(){
       String result = b.callMethod();
    }
}