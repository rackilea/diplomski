String[] atrArray = {"This", "is", "my", "array"}; // 4 elements
String[] result = getVal(atrArray, "i");

// Display the results found:
for (int i = 0; i < result.length; i++) {
    System.out.println("Item " + (i + 1) + " found at atrArray Index: " 
                     + i + " --> " + res[i]);
}