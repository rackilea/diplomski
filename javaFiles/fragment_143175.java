public class Main extends SuperClass {
    {
        System.out.println("Initialiser block before constructor");
    }

    Main() {
        System.out.println("Main constructor");
    }

    {
        System.out.println("Initialiser block after constructor");

    }

    public static void main(String... args) {
        new Main() {{
            System.out.println("Anonymous initalizer block");
        }};
    }
}

class SuperClass {
    SuperClass() {
        System.out.println("SuperClass constructor");
    }
}