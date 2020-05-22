import java.util.stream.IntStream;

public class Main
{
    public static class CustomException extends RuntimeException {
        public CustomException() {
            System.err.println("will deliberately fail");
            throw new NullPointerException();
        }
        private CustomException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            if(Thread.currentThread()!=main)
                throw new CustomException("forced failure");
        });
    }
}