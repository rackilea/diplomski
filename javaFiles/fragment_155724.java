class A{
  private static class B{}
  static class C{ 
    B b;
    C(B b){
        this.b=b;
    }
    int foo(){
        return 42;
    }
  }
  static createC() {
    return new C(new B());
  }
}