String test = "{TEST}(A){";

    Stack<Integer> stack = new Stack<>();
    boolean lastCharIsParantheses = false;
    for (char c : test.toCharArray()) {
        switch (c) {
            case '{':
            case '(': {
                stack.push(1);
                lastCharIsParantheses = true;
                continue;
            }
            case '}':
            case ')':
                stack.pop();
                if (lastCharIsParantheses) {
                    throw new RuntimeException("Empty parantheses");
                }
        }
        lastCharIsParantheses = false;
    }
    if (!stack.empty()) {
        throw new RuntimeException("Not matching number of opened/closed parantheses");
    }