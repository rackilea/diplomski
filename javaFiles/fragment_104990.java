class Cat implements Cloneable {
  // all your properties and methods

  @Override
  public Cat clone() throws CloneNotSupportedException {
        return (Cat)super.clone(); // if you need deep copy you might write your custom code here
  }

  public void Reproduce(){
    Cat c = this.clone();
    // change some properties of object c if needed
    addAnimal(c);
  }
}