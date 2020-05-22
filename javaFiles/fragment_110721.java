List<String> selectedLists = new ArrayList<String>();
int[] allowedIndexes = {0, 1, 2, 3};       // only lists at indexes 0, 1, 2 and 3 are inserted into combined list
int index = 0;                             // current index counter
for(List<String> list: myMap.values()) {   // iterate over all existing lists
    if(isInArray(allowedIndexes, index)) { // if the list at current index is allowed, add it to the selected lists
        selectedLists.addAll(list);
    }
    index++;                               // update the index
}
// selectedLists now contains only lists from the allowed indexes