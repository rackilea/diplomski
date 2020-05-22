class MyClass implements alpha, beta {
  void display() {
    System.out.println("This is not default");
  }

  @Override
  public void reset() {
    //in order to call alpha's reset
    alpha.super.reset();
    //if you want to call beta's reset 
    beta.super.reset();

  }
}