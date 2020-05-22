public ThreadBall(MainFrame pFrame) {

  pFrame.addKeyListener(new keyListener());
  this.setBackground(Color.white);
  this.xDirection = 1;
  this.yDirection = 1;
  this.ball = new Rectangle(20, 20);
  ball.x = 150;
  ball.y = 0;

  this.ballThread = new BallThread();
  this.ballThread.start();