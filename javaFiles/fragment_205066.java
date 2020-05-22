class First {

    private static First instance = null;
    private First() {}

    public static First getInstance() {
        if (instance == null) {
            instance = new First();
        }
        return instance;
    }
}

class Second {
    public static void main(String[] args) {
        First f = First.getInstance(); //Always the same instance of First.
    }
}