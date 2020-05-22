class Test
{
  private int size; //global 

  public void method(int size)
  {
    this.size = size; //this.size refers to the declaration within the class, not the method local variable

  }
}