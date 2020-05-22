while (true) { // loop "forever", since we don't know when we'll stop
    if (!sentenceScan.hasNext()) // if there are no more words... 
        break; // ...get the heck out of this loop!
    // get next word from scanner and add it to vector, in one fell swoop:
    vec.add(sentenceScan.next());
}