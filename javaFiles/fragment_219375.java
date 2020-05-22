for (int i=0; i<(MAX_LETTERS-wordLength); i++)
{
    int r = rand.nextInt(25);       

    // SAVE THIS RANDOM LETTER //
    lettersToUse[i] = letters[r];           
}   
for (int i=MAX_LETTERS-wordLength; i<MAX_LETTERS; i++)
{
    // SAVE THIS LETTER OF THE WORD //
    lettersToUse[i] = lettersInName[r]; //I think that lettersInName is the right variable name to use, hopefully you understand what I'm trying to do here           
}   
lettersToUse.shuffle() //or similar method for whatever array type you're using