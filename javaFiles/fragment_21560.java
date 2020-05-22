else if (s.charAt(i) == '}' & c.peek() == '{') {
        c.pop();
    } else if (s.charAt(i) == ']' & c.peek() == '[') {
        c.pop();
    } else if (s.charAt(i) == ')' & c.peek() == '(') {
        c.pop();
    }