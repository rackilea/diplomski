class OuterClass {
 ...
 InnerClass NewInnerClass() {
  return new InnerClass(this);
 }
 void SomeFunction() {
  InnerClass i = this.NewInnerClass();
  i.GetOuterString();
 }
}