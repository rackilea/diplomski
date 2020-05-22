/* In 'lookCoal(); method */
  // timer.schedule(t, 0 2000)   // <-- replace that with this:
  timer.schedule(new MyTask(robot, xRock, yRock), 0, 2000);

/* In 'MyTask' Class */
  // Add the required variables:
  Robot robot;
  int xRock, yRock;

  // Add a constructor like this:
  MyTask(Robot r, int x, int y) {
      this.robot = r;
      this.xRock = x;
      this.yRock = y;
  }

  // Modify the run method, like this:
  public void run() {
      java.awt.Color c = this.robot.getPixelColor(this.xRock, this.yRock);
      ...