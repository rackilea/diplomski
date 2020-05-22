Map<String, Integer>wordCount = new HashMap<String, int>();
for(String seq : yourWordList){
    // increment the count of the word by first obtaining its count,
    // and then incrementing it. Paranthesis for clarity
    wordCount.put(seq, (wordCount.get(seq)) + 1);
}