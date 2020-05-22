$ cat Test.java
class Test {
    boolean m() {
        return true;    <------------
    }
}
$ javac Test.java 
$ javap -c Test
Compiled from "Test.java"
class Test {
  [...]     

  boolean m();
    Code:
       0: iconst_1      
       1: ireturn        <------------
}