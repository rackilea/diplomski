public class Value {
int method1()
{
    int demo=10;
    System.out.println("methd 1"+demo);
    return demo;
}
void method2()
{        
    int demos = this.method1();
    System.out.println("method 2 "+demos);
}

public static void main(String[] args) {
    Value obj = new Value ();
  //  obj.method1();
    obj.method2();
}