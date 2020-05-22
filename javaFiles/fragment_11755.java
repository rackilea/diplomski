int sum = 0;
    int i   = 0;
    while(i < input.length()) {
        int number;
        if(input.substring(i, i+1).equals("-")) {
            number = Integer.parseInt(input.substring(i, i+2));
            i += 2;
        } else {
            number = Integer.parseInt(input.substring(i, i+1));
            i++;
        }
        sum += number;
    }