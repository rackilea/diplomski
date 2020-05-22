public class Playtime extends Thread {

    int playtimei = 0;

    public Playtime(int playtimei) {
        this.playtimei = playtimei;
    }
    @Override
    public void run() {
        while(true)
        {
            playtimei++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}