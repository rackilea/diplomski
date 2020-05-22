public class Player {

    //...

    // I really, really, really don't static been used this way, it
    // has a bad code smell about it...
    public static Set<Character> inputState = new TreeSet<Character>();

    //...

    public static void setKey(char c, boolean b) {
        if (b) {
            inputState.add(c);
        } else {
            inputState.remove(c);
        }
    }

}