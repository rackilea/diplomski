public class ExceptionHandler {

public static  void exceptionHandler(Exception exception){
  //Handling code
}
}

class Example1
{
 public static void main(String args[])
 {
  try{
     int num1=30, num2=0;
     int output=num1/num2;
     System.out.println ("Result: "+output);
  }
  catch(Exception e){
    ExceptionHandler.exceptionHandler(e);
  }
 }
}