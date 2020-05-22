String expression = "c*(a+b)+(a-b)/log(a+b)-(b-c/d)+(d-tan90)";
    List<Character> operators = new ArrayList<Character>();
    int parentheses = 0;
    for (char c : expression.toCharArray()) {
        // throw away everything inside ( )
        if (c == '(') {
            parentheses++;
        } else if (c == ')') {
            parentheses--;
        }
        if (parentheses > 0) {
            continue;
        }

        // store operators outside ( )
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            operators.add(c);
        }
    }
    System.out.println(operators);  // [*, +, /, -, +]