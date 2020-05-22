public static class FirebaseAuth {

    private FirebaseAuth instance;

    private FirebaseAuth() {
        // private constructor that nobody else can create an instance of your class
    }

    public static FirebaseAuth getInstance() {
        if (instance == null) {
            //create instance if necessary
            instance = new FirebaseAuth();
        }
        return instance;
    }
}