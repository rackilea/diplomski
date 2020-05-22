public static void main(String args[]){
    String inStr = "Lambdas add power to Java";
    String outStr;
    outStr = stringOp(LambdasAsArgumentsDemo::mymethod, inStr);
    System.out.println("The string in uppercase: " + outStr);
}

public static String mymethod(String str) { return str.toUpperCase(); }
              ^                 ^                  ^
              |                 |                  implementation
              |                 String argument called str
              String return type