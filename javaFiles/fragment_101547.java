public void firstSpace(String word) 
{  
    int row, column;

    // No need to add 1, Java arrays are accessed with the first index 
    // being 0. Math.random() returns from 0 up to but not including 1.0.
    // e.g. array size = 50, min index = 0, max index = 49
    // Lets say you get very close to 1 e.g. 0.9999, then 
    // 0.9999 * 50 = 49.995 (after integer truncating you have 49)
    row = (int)(Math.random() * gridDimensions);
    column = (int)(Math.random() * gridDimensions);

    if(puzzle[row][column] != ' ') { 
        // If this element is not "empty" then run the method again 
        // using recursion. null might be a better choice to compare
        // to depending on how you initialized the array.
        firstSpace(word);
    } else {
        // Otherwise we're finished and we can set the array element
        // to the new word.

        // (Assumed post condition (you might want to do something else once you
        // find a blank index))
        puzzle[row][column] = word;
    }
}