public class Infout implements Runnable{

    private JFrame frame;
    private JLabel image;
    private Random s = new Random();

    public Infout(JFrame frame, JLabel image){
        this.frame = frame;
        this.image = image;
    }

    @Override
    public void run() {
        while(true){
           int x = s.nextInt(1000);
           int y = s.nextInt(900);

           try{ Thread.sleep(1000); }
           catch(InterruptedException e){ }
           image.setBounds(x, y, 200, 200);
        }
    }
}