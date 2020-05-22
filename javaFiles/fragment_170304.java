import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ControlCircle extends JFrame implements Runnable {
  private JButton jbtStart = new JButton("Start");
  private JButton jbtStop = new JButton("Stop");
  private JButton jbtContinue = new JButton("Continue");
  private JButton jbtReset = new JButton("Reset");
  private CirclePanel canvas = new CirclePanel();

  private JTextField f1;
  private int radius = 0;

  private JTextField f2;
  private int iter;

  protected boolean  incrementalPainting;

  /**
   * Flag indicates that a thread is suspended
   */
  private boolean suspended = false;


  /**An instance of the class Thread.*/
  private Thread thread = null;

  public ControlCircle() {
    JPanel panel = new JPanel();
    JPanel jp = new JPanel();
    jp.setPreferredSize(new Dimension(300, 0));
    panel.add(jbtStart);
    panel.add(jbtStop);
    panel.add(jbtContinue);
    panel.add(jbtReset);

    this.add(jp, BorderLayout.WEST);
    this.add(canvas, BorderLayout.CENTER);
    this.add(panel, BorderLayout.SOUTH);

    f1 = new JTextField(8);
    f2 = new JTextField(8);

    jp.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 30));
    jp.add(new JLabel("Radius"));
    jp.add(f1);
    jp.add(new JLabel("Iteration"));
    jp.add(f2);


    jbtStart.addActionListener(new StartListener());
    jbtStop.addActionListener(new StopListener());
    jbtContinue.addActionListener(new ContinueListener());
    jbtReset.addActionListener(new ResetListener());
  }

  public static void main(String[] args) {
    JFrame frame = new ControlCircle();

    frame.setTitle("ControlCircle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  class StartListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (thread == null) {
        repaint();
        startThread();
      }
    }
  }

  class StopListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (thread != null){
        mySuspend();
      }
    }
  }

  class ContinueListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      myResume();
    }
  }

  class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (thread != null) {
        stopThread();
      }
      repaint();
    }

  }

  /**
   * my Suspend
   */
  private void mySuspend() {
    System.out.println("mySyspend()");
    suspended = true;
  }

  /**
   * my Resume
   */
  private synchronized void myResume(){
    System.out.println("myResume()");
    suspended = false;
    notifyAll();
  }

  public void run(){
    System.out.println("run() - started");

    Thread me = Thread.currentThread();
    while (thread == me) {
      radius = Integer.parseInt(f1.getText());
      iter = Integer.parseInt(f2.getText());
      for (int i = 0; i < iter; i++) {
        if (thread == null) return;
        incrementalPainting = true;
        myRepaint();
        try {
          Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        radius += 10;
      }
      if(thread != null) thread = null; // exiting while
    }
    System.out.println("run() - exiting");
  }

  /**
   * start Thread
   */
  private void startThread(){
    System.out.println("startThread()");
    if(thread == null){
      thread = new Thread(this);
      thread.start();
    }
  }

  /**
   *  stop Thread
   */
  private synchronized void stopThread() {
    System.out.println("stopThread()");
    thread = null; // exiting from while
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  /**
   * This is called from the run method to invoke painting.
   */
  private void myRepaint() {
    System.out.println("myRepaint()");
    incrementalPainting = true;
    repaint();
    synchronized (this) {
      while (incrementalPainting) {
        System.out.println("wait while incremental painting");
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("interrupted");
        }
      }
    }

    suspend();
  }
  /**
   * This method should place somewhere when run() has started. Perfectly
   * when repaint() performed.
   */
  private void suspend(){
    System.out.println("suspend()");
    synchronized (this) {
      while (suspended) {
        System.out.println("wait while suspended");
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("interrupted");
        }
      }
    }

  }

  public synchronized void myPaint(Graphics g) {
    if (g == null){
      if (incrementalPainting){
        incrementalPainting = false;
        notifyAll();
      }
      return;
    }
    if (incrementalPainting){
      myDraw(g);
      incrementalPainting = false;
      notifyAll();

    }
    else {
      myDraw(g);
    }
  }

  public void myDraw(Graphics g){
    g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
  }

  protected final class CirclePanel extends JPanel {
    //Offscreen buffer of this canvas
    private BufferedImage backBuffer = null;

    public void paintComponent (Graphics g) {
      System.out.println("incrementalPainting="+incrementalPainting);
      // First paint background
      super.paintComponent(g);
      Dimension d = this.getSize();
      if (! incrementalPainting)
        backBuffer = (BufferedImage) this.createImage(d.width, d.height);
      Graphics2D g2 = backBuffer.createGraphics();
      if (! incrementalPainting){
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0, d.width, d.height);
      }
      myPaint(g2);
      g.drawImage(backBuffer, 0, 0, this);

    }

  }

}