public class MainTask implements Runnable {

    private static MainTask mainTask;

    private MainTask(){ }

    public static MainTask getInstance(){
        if(mainTask==null){
            mainTask = new MainTask();
        }
        return mainTask;
    }

    @Override
    public void run() {
        // task to run goes here
        System.out.println("Hello !! " + Thread.currentThread().getName());
    }

}