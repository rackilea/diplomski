public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String... args) {
        // ...
        switch(somthing) {
        case "something":
            // ...
            if (!shallContinue()) return;
            break;
        case "something else":
            // ...
            if (!shallContinue()) return;
            break;
        default:
            // ...
            if (!shallContinue()) return;
        }
    }

    public static boolean shallContinue() {
        while (true) {
            System.out.println("Do you want to continue?");
            switch (reader.nextLine().toLowerCase()) {
            case "yes":
                return true;
            case "no":
                return false;
            }
        }
    }
}