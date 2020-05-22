String[] arrayOfStrings = {"abcde", "fghij", "klmno"};
JSONArray array = new JSONArray();

for(int i=0; i<arrayOfString.length; i++){
    array.put(arrayOfStrings[i]);
}

String totalString = array.toString();

// to import the string and decode it you have to do this:

JSONArray newArray = new JSONArray(totalString);

// now each element of the array is the same of the starting array "arrayOfString"