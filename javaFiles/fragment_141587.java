package javaapplication4;

import java.util.function.Function;

public class JavaApplication4 {

    public static class Pruebas 
    {
       public static double fun1(double x)
       {
           return x*1;
       }

       public static double fun2(double x){
           return x*2;
       }
       public static double fun3(double x){
           return x*3;
       }

       public static double eval(Function<Double, Double> fun,double x0)
       {
          double f=fun.apply(x0);
          return f;
       }
    }


    public static void main(String[] args) 
    {
        System.out.println(Pruebas.eval(Pruebas::fun3, 5));
    }

}