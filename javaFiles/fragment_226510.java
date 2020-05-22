// Create the outer dimension of the array, with the same size as the total list
String[][] mergedArray = new String[mergedList.size()][];

// Now iterate over each nested list and convert them into the String[]
// instances that form the inner dimension
for (int i = 0; i < mergedList.size(); i++) {
    mergedArray[i] = mergedList.get(i).toArray(new String[0]);
}