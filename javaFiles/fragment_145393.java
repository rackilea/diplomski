abstract class  Base{
public abstract void set();

private Base(){
System.out.println("Private Constructor!");
}
static class Derived extends Base{
public void set(){
System.out.println("set() method implemented!");
}
}
public static void main(String[] args){
new Base.Derived().set();
}
}