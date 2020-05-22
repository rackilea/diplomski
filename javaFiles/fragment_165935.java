final boolean[] done = new boolean[1];
Runnable r = new Runnable() {
  public void run() {
    done[0] = true;
  }
};
// now wait for the event somehow.  The brute force method:
while (!done[0]) {
  Thread.sleep(200);
}