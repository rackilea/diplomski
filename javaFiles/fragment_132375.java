public void mergeArrays() {

  ArrayList<String[]> list1 = new ArrayList<String[]>();
  list1.add(new String[] { "key1", "a", "a", "a" });
  list1.add(new String[] { "key2", "a", "a", "a" });
  list1.add(new String[] { "key4", "a", "a", "a" });

  ArrayList<String[]> list2 = new ArrayList<String[]>();
  list2.add(new String[] { "key1", "b", "b" });
  list2.add(new String[] { "key2", "b", "b" });
  list2.add(new String[] { "key3", "c", "c" });

  ArrayList<String[]> result = new ArrayList<String[]>();

  // Merge list1 to list2
  for (String[] array1: list1) {
     // Find key from list1 in list2
     int index = this.findIndex(array1[0], list2);

     // Key was found, merge arrays
     if (index > -1) {
        result.add(this.concat(array1, list2.get(index)));
     }
     // Key was not found, use padding
     else {
        // Padding second array with null values
        result.add(this.concat(array1, this.padding(list2.get(0).length, null)));
     }
  }

  // Merge list2 to list1
  for (String[] array2: list2) {
     // Find key from list2 in list1
     int index = this.findIndex(array2[0], list1);

     // Key was not found, use padding
     if (index == -1) {
        // Padding first array with null values
        String[] temp = this.concat(this.padding(list1.get(0).length, null), array2);
        temp[0] = array2[0]; // Set key
        result.add(temp);
     }
  }

  // Debug output
  for (String[] array: result) {
     for (int i = 0; i < array.length; ++i) {
        System.out.print(array[i] + " ");
     }
     System.out.println("");
  }
}

// Return array with padding
private String[] padding(final int size, final String padding) {
  String[] result = new String[size];
  Arrays.fill(result, padding);

  return result;
}

// Find needle in haystack and return index
private int findIndex(final String needle, final ArrayList<String[]> haystack) {
  for (int i = 0; i < haystack.size(); ++i) {
     if (haystack.get(i)[0].equals(needle)) {
        return i;
     }
  }

  return -1;
}

// Merge two arrays, omit first element of second array
private String[] concat(String[] arrayOne, String[] arrayTwo) {
  int arrayOneLength = arrayOne.length;
  int arrayTwoLength = arrayTwo.length;

  String[] result = new String[arrayOneLength + arrayTwoLength - 1];
  System.arraycopy(arrayOne, 0, result, 0, arrayOneLength);
  System.arraycopy(arrayTwo, 1, result, arrayOneLength, arrayTwoLength - 1); // Skip key in second array

  return result;
}