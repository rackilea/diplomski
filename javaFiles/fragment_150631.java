public class Counter implements Runnable {
    public void run ( ) {
        int i = 0;
        while(true) {
            System.out.print(i);
            i++;
        }
    }
}