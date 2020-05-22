C:\>more > A.java
class A {}

C:\>more > B.java
class B {
   void method() {
      A a = new A();
   }
   public static void main( String ... args ) {
       B b = new B();
       b.method();
   }
}
^C
C:\>javac A.java B.java

C:\>erase A.class

C:\>java B
Exception in thread "main" java.lang.NoClassDefFoundError: A
        at B.method(B.java:3)
        at B.main(B.java:7)
Caused by: java.lang.ClassNotFoundException: A
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        ... 2 more