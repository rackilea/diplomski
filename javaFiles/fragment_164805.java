class Superclass {
    Superclass() {
        System.out.println("Superclass ctor");
    }
}

class Subclass extends Superclass {
    private String x = log("x initializer");

    {
        System.out.println("instance initializer");
    }

    private String y = log("y initializer");

    Subclass() {
        System.out.println("Subclass ctor");
    }

    private static String log(String message)
    {
        System.out.println(message);
        return message;
    }
}

public class Test {    
    public static void main(String[] args) throws Exception {
        Subclass x = new Subclass();
    }
}