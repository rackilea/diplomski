public class MyTask implements Runnable {

    private String str;

    public MyTask(String str) {
        this.str = str;
    }

    @Override
    public void run() {

        System.out.println(str);
    }
}