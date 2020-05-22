Data d = new Data("Hello");
Derived<Data> dClass = new Derived<Data>(d);
dClass.printObj(); // output Hello


NonData d1 = new NonData("Bye");
Derived<NonData> dClass1 = new Derived<NonData>(d1);
dClass1.printObj(); // output Bye