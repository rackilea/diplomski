public static void main(final String[] args) {
    final Map<Character, Character> closeToOpen = new HashMap<Character, Character>();
    closeToOpen.put('}', '{');
    closeToOpen.put(']', '[');
    closeToOpen.put(')', '(');
    closeToOpen.put('>', '<');

    final String[] testSet = new String[] { "abcdefksdhgs", "[{aaa<bb>dd}]<232>", "[ff{<gg}]<ttt>", "{<}>" };
    for (final String test : testSet) {
        System.out.println(test + "  ->  " + isBalanced(test, new LinkedList<Character>(), closeToOpen));
    }
}