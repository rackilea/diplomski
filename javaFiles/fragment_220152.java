public class MyCanvas {

  public static void main(String[] args) {
    new MyCanvas("MyCanvas",new Dimension(400,400));
  }

  private static final int frameRate = 1000 / 30;

  private JFrame frame;
  private JPanel panel;
  private int delta;
  private long lastLoopTime;
  private volatile boolean running = false;
  private int frameCount = 0;

  public MyCanvas(String name, Dimension size) {
    frame = new JFrame(name);
    panel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        if (running) repaint();
      }
    };
    frame.setContentPane(panel);
    frame.setSize(size);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setPreferredSize(size);
    panel.setLayout(null);
    frame.setResizable(true);
    running = true;
    frame.setVisible(true);
    lastLoopTime = System.nanoTime();
    new Thread(()->{
      while (running) {
        update();
        frameCount++;
        try {
          Thread.sleep(frameRate);
        } catch (InterruptedException e) {}
      }
    },"Game Loop").start();
  }

  int x = 30;

  public final void update() {
    x++;
  }

  public final void draw(Graphics g) {
    g.setColor(Color.darkGray);
    g.fillRect(0,0,getSize().width,getSize().height);
    g.setColor(Color.gray);
    g.fillRect(0,0,500,500);
    g.setColor(Color.blue);
    g.fillRect(x,30,300,300);
  }

  public final Dimension getSize() {
    return frame.getSize();
  }

  public final void setSize(Dimension size) {
    frame.setSize(size);
  }

}