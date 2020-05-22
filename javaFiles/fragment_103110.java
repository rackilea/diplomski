import java.util.*;
import java.lang.*;
import java.io.*;

interface StringFunc {
    String func(String n);
}
interface StringFunc2 {
    String func(String n);
}
interface StringFunc3 {
    String func(String n);
}

class LambdasAsArgumentsDemo {

    public static void main(String args[]){
        String inStr = "Lambdas add power to Java";
        String outStr;
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase: " + outStr);
    }

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s)+"2";
    }

    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s)+"3";
    }
}