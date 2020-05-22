public abstract class Foo {

    public void doStuff(){
        int id = getID(); // <==== get the ID
    }

    public abstract int getID();
}

public class Bar extends Foo {

    private int ID = 100;

    public int getID() {
      return ID;
    }
}