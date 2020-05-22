Matcher matcher;

int indexOfLongestMatch = -1;
int maxLength = 0;

for (int i = 0; i < stringList.size(); i++) {                 // Iterate the List
    matcher = pattern.matcher(stringList.get(i));             // Apply the pattern
    if (matcher.matches()) {                                  // Has a match?
        int length = matcher.group(0).length();
        if (length >= maxLength) {                            // Check for the new max
            maxLength = length;                               // Register it
            indexOfLongestMatch = i;                          // New index of the max
        }
    }
}