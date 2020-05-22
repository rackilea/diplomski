String guess = "l";
    int start = 0;
    do {
        int index = theWord.indexOf(guess, start);
        if(index >= 0) {
            wordTemplate.replace(index, index + 1, guess);
            start = index + 1;
        } else
            break;
    } while (true);

    System.out.println(wordTemplate);