// While we are getting the word in the sentence
// i.e while it is not returning -1
while(lastIndex != -1) {
    // Will get the last index of the searched word
    lastIndex = sentence.indexOf(word, lastIndex);

    // Will check whether word found or not 
    if(lastIndex != -1) {
        // If found will increment the word count
        count++;
        // Increment the lastIndex by the word lenght
        lastIndex += word.length();
    }
}

// Print the count
System.out.println(count);