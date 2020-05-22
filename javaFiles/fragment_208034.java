public static String getRandomWord() {
    switch(new Random().nextInt(5)) {
        case 0:
            return "Peace";
        case 1:
            return "Nuts";
        // ...
        default:
            throw new IllegalStateException("Something went wrong!");
    }
}