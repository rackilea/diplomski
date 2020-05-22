evan@vbox:~> cat MyClass.java
public class MyClass
{
    public static int add(int x, int y)
    {
        return x + y;
    }
}
evan@vbox:~> javac MyClass.java
evan@vbox:~> jar cvf MyJar.jar MyClass.class
added manifest
adding: MyClass.class(in = 244) (out= 192)(deflated 21%)
evan@vbox:~> spark --jars ./MyJar.jar
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.0.1
      /_/

Using Scala version 2.11.8 (OpenJDK 64-Bit Server VM, Java 1.8.0_111)
Type in expressions to have them evaluated.
Type :help for more information.

scala> MyClass.add(2,3)
res0: Int = 5