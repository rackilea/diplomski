// Returns array of congress member objects sorted alphabetically by first
// name
public static CongressMembers[] sortByFirstName(CongressMembers[] inarray) {
    CongressMembers temp;
    CongressMembers[] array = new CongressMembers[inarray.length];
    System.arraycopy(inarray, 0, array, 0, array.length);
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j + 1].getName().compareTo(array[j].getName()) < 0) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;

}

// Returns array of congress member objects by average approval rating
// (highest to lowest)
public static CongressMembers[] sortByApprovalRating(CongressMembers[] inarray) {
    CongressMembers temp;
    CongressMembers[] array = new CongressMembers[inarray.length];
    System.arraycopy(inarray, 0, array, 0, array.length);
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j + 1].getAvgApprovalRating() > array[j].getAvgApprovalRating()) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;

}