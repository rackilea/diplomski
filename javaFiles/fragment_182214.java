import javax.swing.*; 
PApplet r, b;
PFrame rf, bf;
String nextWindow = "red";
int controllerCounter = 200;
String control = "preparing...";
void setup() {
  size(400, 400);
  r = new RedBG();
  b = new BlueBG();
  frame.setTitle("controller");
  fill(0);
}
void draw() {
  background(255);
  if (controllerCounter < 1) {
    switchState();
    controllerCounter = 200;
  }
  control = null;
  control = "Launching " + nextWindow + " in: " + controllerCounter;
  text(control, width*0.5, height*0.5, width, height);
  controllerCounter--;
}
void switchState() {
  if (nextWindow == null) {
    stopApplet(b);
    nextWindow = "red";
  } 
  else if (nextWindow.equals("red")) {
    startApplet(r);
    nextWindow = "blue";
  } 
  else if (nextWindow.equals("blue")) {
    stopApplet(r);
    startApplet(b);
    nextWindow = null;
  }
}
void startApplet(final PApplet p) {
  if (p == null) return;
  final PFrame f = new PFrame(p);
  p.frame = f;
  f.setTitle(p.getClass() + " window");
  //this thread is only necessary if you are restarting the PApplets
  Thread t = new Thread(new Runnable() {
    public void run() {
      p.setup();
    }
  });
  t.run();
}
void stopApplet(PApplet p) {
  if (p == null || p.frame == null) return;
  p.dispose();
  p.frame.dispose();
}
public class PFrame extends JFrame {
  public PFrame(PApplet p) {
    setSize(400, 400);
    add(p);
    p.init();
    show();
  }
}