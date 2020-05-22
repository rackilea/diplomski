String insertNewlineChars(String textToDisplay, Float maxLabelWidth, BitmapFont font)
{

    float textWidth=0;
    ArrayList<String> words = new ArrayList<String>(Arrays.asList(textToDisplay.split(" ")));
    String addWordsToSentence;

    //add first word
    String nextWord = words.get(0) ;
    addWordsToSentence = nextWord + " ";
    textWidth = font.getBounds(addWordsToSentence).width;

    //add 2nd to last word
    for(int i=1;i<words.size();i++)
    {
        nextWord = words.get(i);
        textWidth += font.getBounds(nextWord).width;

        //add word to a new line
        if(textWidth >  maxLabelWidth)
        {
            //push to next line
            textWidth = font.getBounds(nextWord).width;
            addWordsToSentence = addWordsToSentence.concat("\n" + nextWord + " ");
        }

        //add word to the same line
        else
        {
            addWordsToSentence = addWordsToSentence.concat(nextWord + " ");
        }

    }
    return addWordsToSentence;

}