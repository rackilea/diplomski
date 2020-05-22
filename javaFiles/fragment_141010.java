static final char[] ops = { '-', '+', '*', '/'};

    static double evaluate(String s){
        for(char op: ops) {
            if(s.contains(String.valueOf(op))){
                String op1 = s.substring(0, s.indexOf(op));
                String op2 = s.substring(s.indexOf(op) + 1, s.length());
                switch(op) {
                    case '-': return evaluate(op1) - evaluate(op2);
                    case '+': return evaluate(op1) + evaluate(op2);
                    case '*': return evaluate(op1) * evaluate(op2);
                    case '/': return evaluate(op1) / evaluate(op2);
                }
            }
        }
        /* at this point there is no operator in the term anymore, just a number */
        return (convertToDouble(s));
    }

    private static double convertToDouble(String s) {
        return Double.parseDouble(s);
    }