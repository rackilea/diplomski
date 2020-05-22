// there is only one box
Box box = new Box();

// one part of your code
box.set(10);

// another part of your code (Imagine box is passed to some other class and you forgot that it actually has an Integer)
String myString = (String)box.get(); // error!