int choice = in.nextInt();

switch(choice) {
  case 1: animal = new Dog(); break;
  case 2: animal = new Cat(); break;
  default: animal = new Cow(); break;
}