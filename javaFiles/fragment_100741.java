MultiMap<IMyObjects> multimap;


class MyTestObjects implements IMyObjects {
private int hashCodeToUse = 42;

public int hashCode() {
  return hashCodeToUse;
}

// TODO write setter for hashCodetoUse
}

public void testHashCode() {
  // TODO init multipam
  MyTestObject obj1 = new MyTestObject();
  obj1.setHashCodeToUse(234);
  multimap.put(obj1);
}