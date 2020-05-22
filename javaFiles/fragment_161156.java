interface MathOperartor{
  //it also can be removed, since a int can cast to a float automatically
  default Object operate(int a, int b){
     return operate((float)a, (float)b);
  }
  public Object operate(float a, float b);
}