package test.example;

public class ExceptionTest {

    public static void main(String[] args) throws Exception{
        try {
            int value = 1/0;
        } catch (Exception e) {
            System.out.println("woops the world is going to end");
            throw e;
        }

    }

}