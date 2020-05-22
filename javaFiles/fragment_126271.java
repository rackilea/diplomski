boolean alt = false;
    for(int i = ccNum.length() - 1; i >= 0; i--, alt = !alt){
        int number = ccNum.charAt(i) - '0';
        if(alt)
            number *= 2;
        if(number > 9)
            number -= 9;
        sum += number;
    }
    boolean valid = (sum % 10 == 0);