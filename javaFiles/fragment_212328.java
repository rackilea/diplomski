public void convertNumtoDigitArray(String guessConvert)
{
    String[] userGuessSplit = guessConvert.split(",");
    int[] userGuessArray = new int[userGuessSplit.length];
    for (int j=0; j<userGuessSplit.length; j++)
    {
        userGuessArray[j] = Integer.parseInt(userGuessSplit[j]);
    }
}