String pickRandomWord = ""; // select your random word
char[] displayOutput = new char[pickRandomWord.length()];
for(int n = 0; n < displayOutput.length; ++n)
    displayOutput[n] = '-';

/* ... */

if(letterGuessBoolean) // do not compare against true, if it is already boolean!
{
    for(int position = 0; position < pickRandomWord.length(); ++position)
    {
        if (pickRandomWord.charAt(position) == letterGuess)
        {
            displayOutput[position] = letterGuess;
        }
        System.out.print(displayOutput[position]);
    }
}