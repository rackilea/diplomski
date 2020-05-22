class Abc {
    public Abc() {
        System.out.println("constructor A");
    }
}

class Bb extends Abc {   
    public Bb() {
        super(); // Calls Abc()
        System.out.println("constructor B");
    }
}

public class X {
    public static void main(String args[]) {
        Bb b = new Bb();
    }
}