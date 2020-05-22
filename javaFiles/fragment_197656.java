public class Test {
static Timer timer = new Timer();

public static void main(String[] args) {
    timer.scheduleAtFixedRate(new timeTask(), 10000, 10000);
}

private static class timeTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("inside task");
    }

}
}