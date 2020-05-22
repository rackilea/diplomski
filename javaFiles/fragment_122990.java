public class Solution
{
    public static void main(String[] args) {
        //You can call static methods from another static method without an instance of the class. 
        //So you can do this if it is static. Notice I did not create an instance of Example. 
        Example.staticMethod();
        System.out.println(Example.staticVariable);
        //However these will NOT compile
        //Example.nonStaticMethod
        //System.out.println(Example.nonStaticVariable);

        //If you want access to the nonStaticMethod you need an instance. 
        Example myExample = new Example();
        myExample.nonStaticMethod();  //This WILL compile. 
        System.out.println(myExample.nonStaticVariable); //Will compile
    }
}

class Example{
    static String staticVariable = "";
    public String nonStaticVariable = "";
    public static void staticMethod(){
    }
    public void nonStaticMethod(){
    }
}