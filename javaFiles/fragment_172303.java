public String reverseString(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        stack.push(s.charAt(i));
    }
    while (!stack.empty()) {
        stringBuilder.append(stack.pop());
    }
    return stringBuilder.toString();
}