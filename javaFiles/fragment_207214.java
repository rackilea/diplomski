public static String broken(String input) {
    // *We* know that we'll always go into the body of the loop...
    for (int x = input.length(); x >= 0; x--) {
        return input;
    }
    // The end of the method is still reachable from the compiler's standpoint
}