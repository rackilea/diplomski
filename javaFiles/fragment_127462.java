static boolean contains(Integer[][] array, Integer wantedInt) {
    // For each sub-array
    for (int i = 0; i < array.length; i++) {
        // For each element in the sub-array
        for (int j = 0; j < array[i].length; j++) {
            // If the element is the wanted one
            if (array[i][j].equals(wantedInt)) {
                // We've found it
                return true;
            }
        }
    }
    // We didn't find the wanted number
    return false;
}