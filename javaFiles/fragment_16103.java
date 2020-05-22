String sentence = "He went to Accra today";
    while((sentence.length() < 10) || (sentence.length() > 10)){
        sentence = sentence.substring(1);
        sentence = sentence.substring(0,sentence.length()-1);
    }
    System.out.println("Middle 10 is \""+sentence+"\"");