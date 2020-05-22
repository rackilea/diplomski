public class Main {
    private static final int HOMECALLTIME = 10;

    static private void createHomeCallTimer() {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            public void run() {
                // log.info("homeCall run");
                // Main main = new Main();
                String data = "xxxxx";
                System.out.println(data);

                // log.info("Start of HOMECALL with data: " + data);
                // new TCPClient().openSocketAndSendData(data);
                createHomeCallTimer();

            }
        }, HOMECALLTIME);
    }

    public static void main(String[] args) {
        createHomeCallTimer();
    }
}