for(int spot = 0; spot < wrd[0].length(); spot++)
{
    String tempDisplay = "_";
    for (int spot2 = 0; spot2 <= guessedlet.length() - 1;      spot2++)
    {
        char Spot = wrd[0].charAt(spot);
        String wordletter = Character.toString(Spot);
        char Spot2 = guessedlet.charAt(spot2);
        String guessedletter = Character.toString(Spot2);
        for(int spot3 = 0; spot3 < guessedlet.length(); spot3++)
        {
            char Spot3 = guessedlet.charAt(spot3);
            String guessedletter2 = Character.toString(Spot3);
            if(letter.equals(guessedletter2))
            {
                break;
            }
        }
        if(guessedletter.equalsIgnoreCase(wordletter))
        {
            tempDisplay = guessedletter;
            break;
        }
    }
    out.print(tempDisplay + " ");
}