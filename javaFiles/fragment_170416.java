Runnable[] runnableArray = new Runnable[2];

void setup() {
  Runnable aRunnable = new Runnable() {
    public void run() {
      println("A pressed.");
    }
  };

  Runnable bRunnable = new Runnable() {
    public void run() {
      println("B pressed.");
    }
  };

  runnableArray[0] = aRunnable;
  runnableArray[1] = bRunnable;
}

void draw() {
}

void keyPressed() {

  // a = 97, b = 98
  if(key >= 'a' && key <= 'b'){
    int index = key - 97;
    runnableArray[index].run();
  }
}