C:\>more > A.java
class A {}
^C
C:\>more > B.java
class B {
   public void method() {
      A a = new A();
    }
    public void other() {
       System.out.println("Hello there");
    }
    public static void main( String ... args ) {
        B b = new B();
        b.other();
    }
}

C:\>javac A.java B.java

C:\>erase A.class

C:\>java B
Hello there