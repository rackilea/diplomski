public final String[][] pocketArray = {{"STATUS CHANGERS", "RUNES", "KEY ITEMS", "TROPHIES"},
        {"POTION", "SUPER POTION", "FULL HEAL"}, {"ARMOR+", "ATTACK+", "EXP+", "HEALTH+", "DISPELL+"},
        {"QUEST ITEMS", "STORY ITEMS", "JOURNAL"}, {"TROPHIES"}};


public final List<List<String>> pocketList;

public Test()
{
    pocketList = new ArrayList<>(pocketArray.length);
    for (String[] pocket : pocketArray)
    {
        List<String> currentSubList = new ArrayList<>(pocket.length);
        // Nice and fast way instead of iterating over the whole array and adding the strings to the list.
        Collections.addAll(currentSubList, pocket);
        // instead, you could do something like this:
        //
        // for (String currentString : pocket)
        // {
        //     currentSubList.add(currentString);
        // }
        //
        pocketList.add(currentSubList);

        // Alternatively, you could use something like this:
        // pocketList.add(Arrays.asList(pocket));
    }
}