Thread t = new Thread(new Runnable() { 

  public void run() {
    // stuff your code here
  }

});
t.run();

while (t.isAlive()) {
  t.join(1000); // wait for one second
  System.out.println("still waiting");
}