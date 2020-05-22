class MyStringGenerator{
  private int q;
  private int w;
  setQ(int q ){
    this.q = q;
  }
  setW( int w ){
    this.w = w;
  }

  public String getMyString(){
    return String.format("q = %d \nw = %d", q, w);
  }
}