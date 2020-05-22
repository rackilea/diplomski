public class test{
    public static void main(String args[]) throws ClassNotFoundException
    {
        Class className=Class.forName("com.Test.First");
        Method[] methods=className.getMethods();
        System.out.println("First method is" + methods[0]);
    }
}