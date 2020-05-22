public class Subclass extends Superclass {

public static void main(String[] args) {
    Superclass superObject = new Superclass();
    Subclass subObject = new Subclass(superObject);
}

    public Subclass(Superclass abstractClass) {
        //ERROR!!! getData has protected access in Superclass
        for (String entry : abstractClass.getData()) {
            System.out.println(entry);
        }
    }
}