abstract class A{
  protected String name; //Protected so that subclasses can call it

  public String get_name() {
     return name;
  }

  public void set_name(String name) {
    this.name = name;
  }

}

class C extends A{


}

class Aconcrete extends A{

}