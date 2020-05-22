// Returns array of congress member objects sorted alphabetically by first
// name
public static CongressMembers[] sortByFirstName(CongressMembers[] inarray) {
    CongressMembers[] array = new CongressMembers[inarray.length];
    System.arraycopy(inarray, 0, array, 0, array.length);
    Arrays.sort(array, (elem1, elem2) -> {
        return String.CASE_INSENSITIVE_ORDER.compare(elem1.getName(), elem2.getName());
    });
    return array;
}

// Returns array of congress member objects by average approval rating
// (highest to lowest)
public static CongressMembers[] sortByApprovalRating(CongressMembers[] inarray) {
    CongressMembers[] array = new CongressMembers[inarray.length];
    System.arraycopy(inarray, 0, array, 0, array.length);
    Arrays.sort(array, (elem1, elem2) -> {
        Integer.compare(elem1.getAvgApprovalRating(), elem2.getAvgApprovalRating());
    });
    return array;
}