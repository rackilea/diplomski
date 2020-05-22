public static boolean isBalanced(final String str1, final LinkedList<Character> openedBrackets, final Map<Character, Character> closeToOpen) {
    if ((str1 == null) || str1.isEmpty()) {
        return openedBrackets.isEmpty();
    } else if (closeToOpen.containsValue(str1.charAt(0))) {
        openedBrackets.add(str1.charAt(0));
        return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
    } else if (closeToOpen.containsKey(str1.charAt(0))) {
        if (openedBrackets.getLast() == closeToOpen.get(str1.charAt(0))) {
            openedBrackets.removeLast();
            return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
        } else {
            return false;
        }
    } else {
        return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
    }
}