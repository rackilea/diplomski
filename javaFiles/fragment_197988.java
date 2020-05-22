MyClass obj = new MyClass();
obj.setId("newStringId");
session.save(obj);
session.flush();
session.refresh(obj);
obj.getAutoValue();   // should have the auto generated value