public static boolean containsChar(char[] lookIn, char lookFor) {
    boolean doesContainChar = false;
    for(char c : lookIn) {
        if(doesContainChar = c == lookFor)
            break;
    }
    return doesContainChar;
}