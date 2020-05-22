abstract Class parent {

protected abstract void myTemplateMethod();

protected final void myMethod() {
 if(someCodition) {
    myTemplateMethod();
  }
}

Class child extends Parent {

@override
protected void myTemplateMethod() {
 //code that will be invoked only if someCodition is met
  }
}