private void foo3(Map<String, Object> properties) {
  validateB(properties);
  ...
  validateX(properties);    
}


public ThingId foo1(Map<String, Object> properties) {
  checkSomething();
  validateA(properties);
  foo3(properties);
  return createTheThing(properties);

}

public ThingId foo2(Map<String, Object> properties,MoreStuff stuff) {
  checkSomething();
  foo3(properties);
  return createTheThing(properties,stuff);
}