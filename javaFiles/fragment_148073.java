int length = array1.size();
if (length != array2.size()) { // Too many names, or too many numbers
    // Fail
}
ArrayList<String> array3 = new ArrayList<String>(length); // Make a new list
for (int i = 0; i < length; i++) { // Loop through every name/phone number combo
    array3.add(array1.get(i) + " " + array2.get(i)); // Concat the two, and add it
}