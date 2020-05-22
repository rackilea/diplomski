interface Common { 
  String getName();
}

abstract class CommonAdapter implements Common {
   String name;

   String getName() {
     return name;
   }

   //setter as well
}

//just extend the adapter and enjoy
class Object1 extends CommonAdapter {
  //specific code for Object1
}

//extending not possible, so implement the interface directly
class Object2 extends SomeOtherClass implements Common {
  String name;

  String getName() {
    return name;
  }
}

class Handler {
  void handle( Common c ) {
    c.getName();
    ...
  }
}