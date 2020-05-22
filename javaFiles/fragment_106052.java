public class Test extends TimerTask {    
    private static Test instance = new Test();

    private Test() {}    
    public static Test getInstance() {
        return instance;
    }

    @Override
    public void run() {
        System.out.println("In run method");
    }
}