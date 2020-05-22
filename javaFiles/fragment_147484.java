public class MultipleArgs {
public static void main(String [] args){
    run(new Foo("foo1"), new Foo("foo2"), new Foo("foo3"));
}
public static void run(Foo... foos){
    MyFoo[] myFoos = null;
    if (foos != null) {
    myFoos = new MyFoo[foos.length];
       for (int i = 0; i < foos.length; i++) {
        myFoos[i] = wrap(foos[i]);
       }
      }
      run(myFoos);
}
public static void run(MyFoo... myFoos){
     if (myFoos!= null) {
           for (MyFoo myFoo: myFoos) {
            myFoo.bar();
           }
          }

}
private static class Foo {
    public final String s;
    public Foo(String s){
        this.s = s;
    }
    @Override
    public String toString(){
        return s;
    }
}
private static class MyFoo{
    private final String s;
    public MyFoo(String s){
        this.s = s;
    }
    public void bar(){
        System.out.println(s);
    }
    @Override
    public String toString(){
        return s;
    }
}
private static MyFoo wrap(Foo foo){
    return new MyFoo(foo.s); 
}