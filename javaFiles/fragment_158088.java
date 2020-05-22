if(infixExpr.charAt(i) == '('){
            inNumber = false;
            s.push(infixExpr.charAt(i));
        }
        if(infixExpr.charAt(i) == ')'){
            inNumber = false;
            char popped;
            while ( ( popped = s.pop() ) != '(' ) {
                    postfix = postfix + " " + popped;
            }
        }