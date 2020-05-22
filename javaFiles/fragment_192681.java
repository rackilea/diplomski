public class Test {

    public static void main(String[] args)  {
        try {
            Class<?> myClass = Test.class.getClassLoader().loadClass("Test");
            System.out.println(myClass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}