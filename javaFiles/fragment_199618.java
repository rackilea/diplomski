public class Word {
    private int wordCount, sentenceCount, syllableCount;
    private char vowels [] = {'a','e','i','o','u','y','A','E','I','O','U','Y'};
    private char punctuation [] = {'!','?','.',';',':','-','"','(',')',','};

    public Word()
    {
        wordCount = 0;
        sentenceCount = 0;
        syllableCount = 0;
    }

    public Word(String next)
    {
        // Remove numbers
        next = next.replaceAll("[0-9]", "");
        // Skip over blank tokens
        if(next.contains(" ") || next.length() < 1)
                return;

        // String builder method used for removing all non-sentence ending
        // grammar marks.
        StringBuilder newNext = new StringBuilder(next);
        String tempNext;
        if(newNext.length() > 0)
        {
            for(int i = 5; i < punctuation.length; i++)
                for(int j = 0; j < newNext.length(); j++)
                    if(punctuation[i] == newNext.charAt(j))
                    {
                         newNext = newNext.deleteCharAt(j);
                    }
            tempNext = newNext.toString();
            next = tempNext;

            if(next.length() < 1)
                return;
            else
                wordCount++;
        }

        // Count sentences
        for(int i = 0; i < 5; i++)
            if(next.charAt(next.length()-1) == punctuation[i])
                sentenceCount++;

        // Counts all syllables
        if(next.length() > 2)
        {
            for(int i = 0; i < vowels.length; i++)
                for(int j = 0; j < next.length()-1; j++)
                    if(vowels[i] == next.charAt(j))
                        syllableCount++;
        }
        //System.out.println(next);
    }