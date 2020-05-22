public class test{
    public static void main(String args[])
    {
        try {
          Class className=Class.forName("com.Test.First");
          Method[] methods=className.getMethods();
          System.out.println("First method is" + methods[0]);
       }
       catch (ClassNotFoundException ex) {
         ex.printStackTrace();
       }
    }
}