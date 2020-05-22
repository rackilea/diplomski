import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            if(Thread.currentThread()!=main)
                throw new NullPointerException();
        });
    }
}