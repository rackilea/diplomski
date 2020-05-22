private static int countingWord(String value, String findWord)
    {
        int counter = 0;
        while (value.contains(findWord))
        {
            int index = value.indexOf(findWord);
            value = value.substring(index + findWord.length(), value.length());
            counter++;
        }
        return counter;
    }