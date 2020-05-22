class Test {
 // now iVar1 refers to an integer object which wraps int 0.
 static Integer iVar1 = new Integer(0);

 // uninitialized int variable iVar2 gets the default value of 0.
 static int iVar2;

 public static void main(String...args) {
  System.out.println(iVar1.intValue()); // prints 0.
  System.out.println(iVar2); // prints 0.
 }
}