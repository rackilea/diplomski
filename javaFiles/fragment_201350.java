String input = "3[a2[c]]2[abc]3[cd]ef";
Stack<Integer> stack = new Stack<> ();
int first = -1;
int second = -1;

for (int index = 0; index < input.length(); index++) {
    if (input.charAt(index) == '[') {
        stack.push(index);
    } else if (input.charAt(index) == ']' && !stack.isEmpty ()) {
        first = stack.pop ();
        if (stack.isEmpty ()) {
            second = index;
            break;
        }
    }
}

if (first >= 0 && second >= 0) {
    System.out.println(first);
    System.out.println(second);
} else {
  System.out.println ("not found");
}