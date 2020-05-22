public static void ABCgenerator(String from, int lettersLeft) {
        lettersLeft--;
        if (lettersLeft + 1 == 0) {
            System.out.println(from);
        } else {
            ABCgenerator(from + "a", lettersLeft);
            ABCgenerator(from + "b", lettersLeft);
            ABCgenerator(from + "c", lettersLeft);
        }
    }
}