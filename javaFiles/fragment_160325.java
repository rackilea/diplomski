Class f = Class.forName("Foo");
Object inst = f.newInstance();
Field aField = f.getDeclaredField("a");
aField.setInt(inst, 42);
Field bField = f.getDeclaredField("b");
bField.setInt(inst, 67);