public static boolean isWellFormed(String input) {
    if (input == null) return true;

    Stack<Character> stack = new Stack<Character>();
    Map<Character,Character> map = new HashMap<Character,Character>();

    map.put('}', '{');
    map.put(')', '(');
    map.put(']', '[');

    for (int i=0; i < input.length(); i++) {
        char s = input.charAt(i);

        if (s == '[' || s == '{' || s == '(') {
            stack.push(s);
        }
        if (s == ']' || s == '}' || s == ')') {
            if (map.get(s) != stack.pop()) {
                return false;
            }
        }
    }

    if (!stack.isEmpty()) {
        return false;
    }
    else {
        return true;
    }
}