abstract class A
{
String name;
public abstract void print();
}
class B extends A
{
@Override
public void print(){
System.out.println("Hello");
}
//Overloaded method with String parameter
public void print(String s){
System.out.println("Hello" + s);
}
public static void main(String[] args){
new B().print();//calling inherited method with class B object
new B().print("Bishal");//calling overloaded method with class B object
}
}