if(Character.isDigit(infixExpr.charAt(i)) == true){
            if ( ! inNumber ) {
                postfix += " ";
            }
            postfix = postfix + infixExpr.charAt(i);
            inNumber = true;
        }