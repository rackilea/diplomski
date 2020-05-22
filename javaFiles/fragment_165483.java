// list to hold other lists
List<List<Integer>> listOfLists = new ArrayList<>();

// inner list to be added to above list
List<Integer> innerList = new ArrayList<>();
for (int i = 0; i < arr.length; i++) {  

    // if we need to create a new inner list, add old to 
    // list of lists and create new one          
    if (i != 0 && arr[i] < arr[i - 1]) {
        listOfLists.add(innerList);
        innerList = new ArrayList<>();
    }

    // always add to the current inner list
    innerList.add(arr[i]);
}

// when all is done, add last inner list to list of lists
listOfLists.add(innerList);