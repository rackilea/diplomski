void setup(){

    FirstApplet Applet1 = new FirstApplet();
    PApplet.runSketch(new String[] {"DataWin1"},Applet1);

    SecondApplet Applet2 = new SecondApplet();
    PApplet.runSketch(new String[] {"DataWin2"},Applet2);

  }

  public class FirstApplet extends PApplet {

    void settings(){
      size(600, 600);
    }

    void draw(){
      background(100, 45, 45);
    }

  }

  public class SecondApplet extends PApplet {

    void settings(){
      size(200, 200);
    }

    void draw(){
      background(100, 45, 100);
    }

  }