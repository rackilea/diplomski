List<String> selectedLists = new ArrayList<String>();
int[] allowedIndexes = {0, 1, 2, 3};                                          // only lists at indexes 0, 1, 2 and 3 are inserted into combined list
List<List<String>> listOfLists = new ArrayList<List<String>>(myMap.values()); // convert Collection to List
for(int i = 0; i < allowedIndexes.length; i++) {                              // if allowed index is within the bounds of the amount of lists, add the list at that index to selected lists
    int index = allowedIndexes[i];
    if(index < listOfLists.size()) {
        selectedLists.addAll(listOfLists.get(index));
    }
}
// selectedLists now contains only lists from the allowed indexes