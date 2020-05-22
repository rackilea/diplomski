public class ThisIsAClass {

String string; //accessible globally
....
//way down the class

    public void methodOne(){
        System.out.println(string);
    }
    public void methodTwo(){
        String string = "This string will be printed by methodOne"; //edit the string here
        methodOne();
    }