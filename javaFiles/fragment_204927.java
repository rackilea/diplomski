Map<Integer, Set<Integer>> data = new HashMap<Integer, Set<Integer>>();
for(;;) // use your loop here
{
    int document;
    int index;
    // Do some stuff to get index and so on
    if(!data.containsKey(document))
    {
        data.put(document, new HashSet<Integer>());
    }
    data.get(document).add(index);
}

// Output

for(Map.Entry<Integer, Set<Integer>> entry : data.entrySet())
{
    int maxIndex = -1;
    int maxScore = Integer.MIN_VALUE;
    for(Integer index : entry.getValue())
    {
        int score;
        //get the score for index
        if(score > maxScore)
        {
            maxScore = score;
            maxIndex = index;
        }
    }
    System.out.println("Document: "+entry.getKey()+" Index with max score: "+maxIndex);
}