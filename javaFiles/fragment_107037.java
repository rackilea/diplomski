System.out.print("Enter some words: ");
    String wordsLine = input.nextLine();
    String[] words  = wordsLine.split(" ");//split the words separated by space
    for(String word: words){
        queue.enqueueFirst(word);//add one word at a time
    }