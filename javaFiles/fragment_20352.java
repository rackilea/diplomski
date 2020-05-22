private someClass someThing;
public String getSomeValue(){
  return someThing.getSomeThing();
}
//when someMethof is fired the jlabel should update its text value
public void someMethod(){
  someClass oldValue = someThing;
  someThing = someThingElse;
  this.firePropertyChange("someValue", oldValue, someThing);

}