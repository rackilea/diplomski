FileOutputStream fos = new FileOutputStream("myFoo.tmp");
ObjectOutputStream oos = new ObjectOutputStream(fos);

Foo foo = new Foo();
//Fill the object.

oos.writeObject(foo);