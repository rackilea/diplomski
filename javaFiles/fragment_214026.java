static List<Set<String>> combine(List<List<String>> itemLists)
{
    // Calculate how many combinations we'll need to build
    int remainingCombinations = itemLists.get(0).size();
    for(int i=1; i<itemLists.size(); i++)
    {
        remainingCombinations *= itemLists.get(i).size();
    }

    List<Set<String>> allSets = new ArrayList<Set<String>>();

    // Generate this combination
    for (;remainingCombinations > 0; remainingCombinations --)
    {
        Set<String> currentSet = new HashSet<String>();
        int positionInRow = remainingCombinations;

        // Pick the required element from each list, and add it to the set.
        for(int i=0; i<itemLists.size(); i++)
        {
            int sizeOfRow = itemLists.get(i).size();
            currentSet.add(itemLists.get(i).get(positionInRow % sizeOfRow));
            positionInRow /= sizeOfRow;
        }

        allSets.add(currentSet);
    }
    return allSets;
}