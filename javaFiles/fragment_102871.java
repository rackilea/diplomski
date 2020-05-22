String[] words = {"this", "test"};
    String[] targetList = {"this", "test", "is", "a", "complicated", "test"};
    ArrayList<Integer> indexList[] = new ArrayList[words.length];

    for(int i=0;i<words.length;i++)
        indexList[i] = new ArrayList<Integer>();

    for(int i=0;i<words.length;i++)
    {
        String current = words[i];
        for(int j=0;j<targetList.length;j++)
        {
            if(words[i].equals(targetList[j]))
            {
                indexList[i].add(j);
            }
        }
    }