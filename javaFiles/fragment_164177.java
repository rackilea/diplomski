static void checkBackwards()
{
    for(int i = 1; i < wordList[currentWord].length; i++)
    {
        if(foundColumn - i < 0) return;
        if(wordList[currentWord][i] != board[foundRow][foundColumn - i]) return;
    }
    //if we got to here, update the output
    for(int i = 0; i < wordList[currentWord].length; i++)
    {
        output[foundRow][foundColumn - i] = wordList[currentWord][i];
    }
    return;
}