HashMap<Character, Runnable> keyRunnableMap = new HashMap<Character, Runnable>();

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

  keyRunnableMap.put('a', aRunnable);
  keyRunnableMap.put('b', bRunnable);
}

void draw() {
}

void keyPressed() {
  if (keyRunnableMap.containsKey(key)) {
    keyRunnableMap.get(key).run();
  }
}