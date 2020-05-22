package test.example;

public class ExceptionTest {

    public static void main(String[] args) throws RuntimeException{
        try {
            int value = 1/0;
        } catch (RuntimeException e) {
            System.out.println("woops the world is going to end");
            throw e;
        }

    }

}