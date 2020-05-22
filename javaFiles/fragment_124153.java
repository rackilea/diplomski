public static void main (String[] args) {
    if (! isFalse()) {
        String test;
        do {
            test = "stupid";
        } while (! isFalse() && ! test.equals("stupid"));
        if (! isFalse()) { // connection still open, so not aborted
            System.out.println(test);
        }
    }
}

private static boolean isFalse() {
    return false;
}