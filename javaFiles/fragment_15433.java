public class Usecount {

     public void abc(){
         //When JVM sees that OberAllCountClass is used here, it executes the static block of OverAllCountClass and by the time below statement is executed, overAllCount is initialized
         int mycount = OverAllCountClass.overAllCount
     }
}