import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Bounce2 extends Applet implements ActionListener, AdjustmentListener, Runnable
{
  //runtime variables
  boolean running = false;
  boolean kill = false;

  //buttons
  Button runbutton = new Button("Run");
  Button pausebutton = new Button("Pause");
  Button quitbutton = new Button("Quit");

  //text
  Label speedlabel = new Label("Speed");
  Label sizelabel = new Label("Size");

  Panel drawingpanel;

  //scrollbars
  private final int barHeight = 20, SLIDER_WIDTH = 10, MAXSPEED = 110, MINSPEED = 0, MAX_SIZE = 110, MIN_SIZE = 10;
  Scrollbar speedbar = new Scrollbar(Scrollbar.HORIZONTAL, MAXSPEED/2, SLIDER_WIDTH, MINSPEED, MAXSPEED);
  Scrollbar sizebar = new Scrollbar(Scrollbar.HORIZONTAL, MAX_SIZE/2, SLIDER_WIDTH, MIN_SIZE, MAX_SIZE);

  //drawn objs
  Ball ball;
  int size = 50;
  private Graphics obj;
  Image offscreen = null;
  Point loc = new Point(100,100); //location of the ball
  private Thread ballThread;

  //boundaries
  int boundx = 640;
  int boundy = 400;

  //directions
  int dx = 1; //1 = left, -1 = right
  int dy = 1; //1 = up, -1 = down

  //speed
  int speed = speedbar.getValue();
  int delay = 3000;

  //initialize the applet and draw everything
  public void init()
  {
    double colWeight[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//15 cols
    double rowWeight[] = {1,1,1,1,1,1,1,1,1,1}; //10 rows
    int colWidth[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//15 cols
    int rowHeight[] = {1,1,1,1,1,1,1,1,1,1}; //10 rows
    GridBagConstraints c = new GridBagConstraints();
    GridBagLayout gbl = new GridBagLayout();
    gbl.rowHeights = rowHeight;
    gbl.rowWeights = rowWeight;
    gbl.columnWeights = colWeight;
    gbl.columnWidths = colWidth;
    c.anchor = GridBagConstraints.CENTER;

    setBounds(0,0,480,640);
    setLayout(new BorderLayout());
    Panel controlpanel = new Panel();
    controlpanel.setLayout(gbl);
    controlpanel.setSize(640,80);

    drawingpanel = new Panel();
    drawingpanel.setSize(640,400);
    ball = new Ball();
    drawingpanel.setLayout(new BorderLayout());
    drawingpanel.add("Center",ball);

    //speed scrollbar
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 3;
    c.gridheight = 1;
    c.gridx = 1;
    c.gridy = 7;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.speedbar,c);

    //run button
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.gridx = 5;
    c.gridy = 7;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.runbutton,c);

    //pause button
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.gridx = 8;
    c.gridy = 7;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.pausebutton,c);

    //size scrollbar
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 3;
    c.gridheight = 1;
    c.gridx = 11;
    c.gridy = 7;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.sizebar,c);

    //speed text label
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 3;
    c.gridheight = 1;
    c.gridx = 1;
    c.gridy = 8;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.speedlabel,c);

    //size text label
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 3;
    c.gridheight = 1;
    c.gridx = 11;
    c.gridy = 8;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.sizelabel,c);

    //quit button
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 3;
    c.gridheight = 1;
    c.gridx = 6;
    c.gridy = 9;
    c.fill= GridBagConstraints.HORIZONTAL;
    gbl.setConstraints(this.quitbutton,c);

    //add to the screen
    controlpanel.add(this.speedbar);
    controlpanel.add(this.runbutton);
    controlpanel.add(this.pausebutton);
    controlpanel.add(this.sizebar);
    controlpanel.add(this.speedlabel);
    controlpanel.add(this.sizelabel);
    controlpanel.add(this.quitbutton);

    //add listners
    speedbar.addAdjustmentListener(this);
    runbutton.addActionListener(this);
    pausebutton.addActionListener(this);
    sizebar.addAdjustmentListener(this);
    quitbutton.addActionListener(this);

    //add the panels
    add("South", controlpanel);
    add("Center", drawingpanel);

    //drawing paramaters
    loc = new Point(loc.x+dx, loc.y+dy);
  }

  public void start()
  {
    if (ballThread == null)
    {
      ballThread = new Thread(this);
      ballThread.start();
    }
  }

  public void run()
  {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    while (!kill)
    {
      if (running)
      {
        ball.invalidate();
        ball.repaint();
      }
      try
      {
        Thread.sleep(delay);
      }
      catch(InterruptedException e){System.err.println("Interrupted.");}
    }
    stop();
  }

  public void paint(Graphics g){
    super.paint(g);

  }

  //class to handle animations
  class Ball extends Canvas
  {
    public void move()
    {
      //if it will hit the right or left, flip the x direction and set it
      if (loc.x+size >= boundx || loc.x <= 0)
      { dx *= -1; }
      loc.x += dx;
      //if it will hit the top or bottom, flip the y direction and set it
      if (loc.y+size >= boundy || loc.y <= 0)
      { dy *= -1; }
      loc.y += dy;
    }

    public void update(Graphics g)
    {
      super.update(g);
      Graphics buffer;
      if (offscreen == null)
      {
        offscreen = createImage(getWidth(), getHeight());
      }
      buffer = offscreen.getGraphics();
      mypaint(buffer);
      g.drawImage(offscreen, 0, 0, this);

    }

    public void mypaint(Graphics g)
    {
      g.setColor(getBackground());
      g.fillRect(loc.x,loc.y,boundx, boundy);

      //update loc
      move();

      //draw
      g.setColor(Color.BLACK);
      g.drawOval(loc.x, loc.y, size, size);
      g.fillOval(loc.x, loc.y, size, size);

      //draw rectangles out of vector
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();
    if (source == this.runbutton)
    {
      running = true;
    }
    else if (source == this.pausebutton)
    {
      running = false;
    }
    else if (source == this.quitbutton)
    {
      //kill processes
      kill = true;
      //remove listeners
      stop();
    }
  }

  public void adjustmentValueChanged(AdjustmentEvent e)
  {
    Object source = e.getSource();
    //set the new size.
    if (source == sizebar)
    {
      //check for clipping
      int newsize = sizebar.getValue();

      // x
      if (loc.x+newsize >= boundx)
      {
        newsize = boundx - loc.x - 1;
        sizebar.setValue(newsize);
      }

      // y
      if (loc.y+newsize >= boundy + 100)
      {
        newsize = boundy+100 - loc.y - 1;
        sizebar.setValue(newsize);
      }
      size = newsize;
    }
    if (source == speedbar)
    {
      speed = speedbar.getValue();
      delay = MAXSPEED - speedbar.getValue();
    }
  }

  public void stop()
  {
    this.speedbar.removeAdjustmentListener(this);
    this.runbutton.removeActionListener(this);
    this.pausebutton.removeActionListener(this);
    this.sizebar.removeAdjustmentListener(this);
    this.quitbutton.removeActionListener(this);
    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
  }
}