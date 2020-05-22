String choice = in.next();

switch(choice.toLowerCase()) {
  case "dog": animal = new Dog(); break;
  case "cat": animal = new Cat(); break;
  case "cow": animal = new Cow(); break;
  default: // error
}