/** Fills the region the Turtle is in. 

  A Region is bounded by lines 
  of any other color than the background color and by the border of 
  the Window. <br>

  @return the turtle to allow chaining.
  */
  public Turtle fill(){
    getPlayground().fill(this);
    return this;
  }
  /** Fills the region with coordinates <code>x</code> and <code>y</code>. 

  A Region is bounded by lines 
  of any other color than the background color and by the border of 
  the Window. <br>

  @return the turtle to allow chaining.
  */
  public Turtle fill(double x, double y){
    double oldX = getX();
    double oldY = getY();
    boolean hidden = isHidden();
    ht().setPos(x,y);
    getPlayground().fill(this);
    setPos(oldX, oldY);
    if(!hidden){
      st();
    }
    return this;
  }