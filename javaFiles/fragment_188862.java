public <Any> Any getParam(boolean b){
return((Any)((Boolean)(!b)));
}
public <Any> Any getParam(float a) {
 return((Any)((Float)(a+1)));
}
public <Any> Any getParam(Object b) {
 return((Any)b);
}
public void test(){
  boolean foo = getParam(true);
  float bar = getParam(1.0f);
  float mumble = getParam(this); // will get a class cast exception
}