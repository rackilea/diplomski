if ( ascii >= 48 || ascii <=57) {
        token.append((char) ascii);

        //check if next char is a num
        while ((int) charAt(i+1) >= 48 && (int) charAt(i+1) <= 57) {
                                   //  ^^ NB
            //increment i in for loop to check
            i++;
            token.append((int) charAt(i));
        }
        tokenList.add(token.toString());
    }