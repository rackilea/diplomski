for(int i = 0; i < abbreviations.length; i++) {

    if(test.equals(abbreviations[i])) {
            //assign word to the abbreviated word
            abbreviatedWord = abbreviations[i+1]; //potential arrayoutofbound exception
            break;

    } else {
      abbreviatedWord = test;
    }