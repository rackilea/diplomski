// new int[] with "values"'s length
int[] intValues = new int[values.length];
// looping over String values
for (int i = 0; i < values.length; i++) {
    // trying to parse String value as int
    try {
        // worked, assigning to respective int[] array position
        intValues[i] = Integer.parseInt(values[i]);
    }
    // didn't work, moving over next String value
    // at that position int will have default value 0
    catch (NumberFormatException nfe) {
        continue;
    }
}