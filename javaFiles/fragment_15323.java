String firstWord = dataFile.next().toLowerCase();
Map<String, List<String>> follows = new HashMap<>();
int nWords = 0;
while (dataFile.hasNext())
{
    String secondWord = dataFile.next().toLowerCase();
    nWords++;
    if (nWords % 1000 == 0)
    {
        System.out.println(nWords + " words");
    }

    //and put words into list if not already there
    //check if this word is already in the list
    if (follows.containsKey(firstWord))
    {
        //add the next word to it's linked list
        List list = follows.get(firstWord);
        if (!list.contains(secondWord))
        {
            list.add(secondWord);
        }
    }
    else
    {
        //create new linked list for this word and then add next word
        List list = new LinkedList<String>();
        list.add(secondWord);
        follows.put(firstWord, list);
    }

    //go on to next word
    firstWord = secondWord;
}