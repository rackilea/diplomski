public class DrawingThread extends Thread {
    private boolean goon = true;

    public void run() { 
        //Drawing routine.. stop if goon is no longer true
    }

    public void requestStop() {
        goon = false;
    }
 }