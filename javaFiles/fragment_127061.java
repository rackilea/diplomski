public class UserInterface {

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        userInterface.showDefaultInterface();
    }

    private void showDefaultInterface() {

        // ...
        showArtikelInterface();
        // ...
    }

    private void showArtikelInterface() {

        // ...
        showDefaultInterface();
        // ...
    }
}