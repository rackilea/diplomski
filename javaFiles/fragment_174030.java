if ( ascii >= 48 || ascii <=57) {
        int j = i + 1;

        //check if next char is a num
        while (j < expressionString.length() && charAt(j) >= '0' && charAt(j) <= '9') {
            j++;
        }
        tokenList.add(expressionString.subString(i, j));
        i = j;
    }