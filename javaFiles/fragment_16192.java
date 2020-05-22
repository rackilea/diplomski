static boolean isBalanced(String s) {
    Deque<Character> operators = new LinkedList<>();
    operators.push('#');
    for (int i = 0; i < s.length(); ++i) {
        if (operators.isEmpty()) return false;
        char ch = s.charAt(i);
        switch (ch) {
        case '(': operators.push('#'); break;
        case ')': operators.pop(); break;
        case '+':
            switch (operators.peek()) {
            case '#': operators.pop(); operators.push(ch); break;
            case '+': break;
            default: return false;
            }
            break;
        case '|':
            switch (operators.peek()) {
            case '#': operators.pop(); operators.push(ch); break;
            case '|': break;
            default: return false;
            }
            break;
        }
    }
    return operators.size() == 1;
}