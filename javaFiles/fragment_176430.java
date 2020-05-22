abstract class X {
 public int hitPoints; 
}
// Lions are edible
class Lion extends X{

  public void eat(X x) { // pass an edible object
  int hitPoints = x.hitPoints  - 10;
  System.out.println(x)
  }
}  

//Dogs are edible as well
class Dog extends X{

 public void eat(X x) { // pass an edible object
  int hitPoints = x.hitPoints  - 10;
  System.out.println(x)
  }
}