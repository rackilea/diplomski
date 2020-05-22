for (int i = 0; i < word.length; i++) {
    int count = 0; // reset the counter for each word

    for (int j = 0; j < word.length; j++) {

        if (word[i].equals(word[j])) {
            /* if the words are the same, but j < i, it was already calculated
               and printed earlier, so we can stop checking the current word
               and move on to another one */
            if (j < i) {
                break; // exit the inner loop, continue with the outer one
            }

            count++;
        }
    }

    if (count > 1) {
        System.out.println("the word " + word[i] + " occured " + count + " time");
    }
}