public static String[] generateTable(ArrayList<String> lines){
// A list to store every single element individually
ArrayList<String> sl = new ArrayList<>();
int length = lines.get(0).split(" ").length; // Number of individual
                                            // elements

// Create an array of every element individually
for (String line : lines) {
    String[] sp = line.split(" ");
    for (String semiChars : sp)
        sl.add(semiChars);
}

// This controls iteration
int j = 1;

for (int i = 0; i < sl.size() / lines.size(); i++) {
    int maxLength = 0; // Max length of character within that set
    String fixStr = ""; // String with fixed spaces

    // Determine maximum length from set
    // Compares the element lengths in multiples. Something like:
    // (element i, element i+length, element i+length+length.....)
    while (j < sl.size()) {
        fixStr = sl.get(i + j - 1);
        if (maxLength < sl.get(i + j - 1).length())
            maxLength = sl.get(i + j - 1).length();
        j += length;
    }

    j = 1; // Ready for another loop
    // Add spaces to match max length in set
    while (j < sl.size()) {
        fixStr = "";
        // Gets elements in multiples (same as above loop)
        if (sl.get(i + j - 1).length() < maxLength) {
            fixStr = sl.get(i + j - 1);
            while (fixStr.length() < maxLength)
                fixStr += " ";
            sl.set(i + j - 1, fixStr);
        }
        j += length;
    }

    j = 1; // Ready for another loop
}

// Time to create final array that is returned

String semiElement = ""; // Stores elements as sets of lines
String[] sortedArray = new String[lines.size()]; // The final Array

// Form expression and add it to final Array
for (int i = 0; i < lines.size(); i++) {
    j = 0;
    while (j < length) {
        // Add as many spaces as you want between elements here
        semiElement += (sl.get((i * length) + j) + "   ");
        j++;
    }
    sortedArray[i] = semiElement;
    semiElement = "";
}

return sortedArray;
}