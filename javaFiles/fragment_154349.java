String inp = "a45string1test";
    char[] cs = new char[inp.length()];
    inp.getChars(0, inp.length(), cs, 0);
    Stack<Character> stack = new Stack<Character>();
    for (int i =0;i<cs.length;i++) {
        if (Character.isDigit(cs[i])) continue;
        stack.push(cs[i]);
        cs[i] = '$';
    }
    for (int i=0;i<cs.length;i++) {
        if (cs[i] == '$') cs[i] = stack.pop();
    }
    System.out.println(cs);