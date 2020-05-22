List<List<HandComponent>> unsortedList = new ArrayList<>();
... // Populate list

for(int i = 0; i < unsortedList.size(); i++)
{
    Collections.sort(unsortedList.get(i));
}

Set<List<HandComponent>> sortedDeDupedSet = new HashSet<>(unsortedList);

// Convert back to list since I need order to matter again later on
List<List<HandComponenet>> sortedDeDupedList = new ArrayList<>(sortedDeDupedSet);