public class Fader extends JFrame{
private static final long serialVersionUID = 1L;
static JButton button;

public static float mTransparent = .0f;

Fader(){
    super("A fading button");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    setSize(400,400);

    JButton button = new CustomButton("Submit");

    add(button);
    setVisible(true);

    Blink blink = new Blink(this);
    blink.start();
}

public static void main(String args[]){
    SwingUtilities.invokeLater(new Runnable(){public void run(){new Fader();}});
}

public static float getTransparentLevel() {
    return mTransparent;
}

public  void setTransparentLevel(float newVal) {
    mTransparent = newVal;

    if(button != null){
        button.repaint();

    }
    repaint();


}
}


class Blink extends Thread{

Fader fader;

public Blink(Fader fader) {
    this.fader = fader;
}

@Override
public void run(){

    while(true){        

        if(Fader.getTransparentLevel() == 0.0f){                
            //increase to 1f
            for(int i=1; i<10; i++){
                fader.setTransparentLevel((float)i/10);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }               
        }
        else if(Fader.getTransparentLevel() == 0.9f){
            //increase to 1f
            for(int i=10; i>=0; i--){
                fader.setTransparentLevel((float)i/10);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }       
    }       
}
}


class CustomButton extends JButton {

private static final long serialVersionUID = 1L;
public CustomButton(String s) {
    super(s);       
}

@Override
public void paintComponent(Graphics g){
    super.paintComponent( g );

    Graphics2D g2=(Graphics2D)g.create();
    int h = getHeight();
    int w = getWidth();

    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Fader.getTransparentLevel()));


    Point2D center = new Point2D.Float(100, 50);
    float radius = 150;
    float[] dist = {0.0f, 1.0f};

    Color[] colors = {Color.yellow, Color.red};
    RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
    g2.setPaint(p);     
    g2.fillRect(0, 0, w, h);
    g2.dispose();       

}

public Dimension getPreferredSize(){
    return new Dimension(200,100);
}
}