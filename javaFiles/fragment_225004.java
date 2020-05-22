// iterating
    for(i = 0; i < letter.length; i++){
        letter[i] += (shiftCode); // Start adding shiftcode to letter
        if(!(letter[i] <= 'Z')) {
            // if its bigger than Z subtract 26
            letter[i] -= (26);
        }
        // less than A?
        if(!(letter[i] >= 'A')) {
            // add 26
            letter[i] += (26);
        }
        System.out.print(letter[i]); // print it all out
    }