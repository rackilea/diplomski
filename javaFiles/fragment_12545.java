public void start() {
  MouseEventListener myMouseEventListener = new MouseEventListener(this);
  addMouseListener(myMouseEventListener);
  addMouseMotionListener(myMouseEventListener);

  //this.addMouseListener(new MouseEventListener(this));