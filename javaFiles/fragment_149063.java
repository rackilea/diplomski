while (true) { // loop "forever", since we don't know when we'll stop
    if (!sentenceScan.hasNext()) // if there are no more words... 
        break; // ...get the heck out of this loop!
    String word = sentenceScan.next(); // get next word from scanner
    vec.add(word); // add that word to the vector
}