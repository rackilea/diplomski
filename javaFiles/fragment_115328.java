// Use the Collections.reverse() to reverse your list.
ArrayList<String> myList = new ArrayList<>(Arrays.asList(arr));
Collections.reverse(myList);
// Now, create the array back again from the ArrayList.
arr = myList.toArray(new String[0]);
// Create the adapter.
ArrayAdapter<String> adpt = new ArrayAdapter<>(this,layoutItemId,arr);