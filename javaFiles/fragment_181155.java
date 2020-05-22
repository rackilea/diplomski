public class Main {

    public static void main (String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.execute(() -> methodA());
        executor.schedule(() -> methodB(), 100, TimeUnit.MILLISECONDS);
    }

    public static void methodA(){
        System.out.println("A: " + System.currentTimeMillis());
    }

    public static void methodB(){
        System.out.println("B: " + System.currentTimeMillis());
    }
}