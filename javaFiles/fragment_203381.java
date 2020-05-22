/**
 * Ascertain the largest span between dates of a sorted array in days.
 * @param sortedDateArray Sorted array of java.util.Dates without nulls
 * @return largest span between two batched dates in sortedDateArray in days
 */
public static int largestSpan(Date[] sortedDateArray) {
    int maxDiffDays = 0;
    for (int i = 0, j = 1; i < sortedDateArray.length && j < sortedDateArray.length; i = j++) {
        Date b = sortedDateArray[i + 1];
        Date a = sortedDateArray[i];
        long diff = b.getTime() - a.getTime(); // calculates the difference between to batched dates (a and b) in ms
        int diffDays = (int) (diff / (1000 * 60 * 60 * 24)); // converts the difference from ms to days

        System.out.println(diffDays + " days between " + a.toString()
                + " and " + b.toString()); // prints out the difference in days (just for debugging)

        if (diffDays > maxDiffDays)
            maxDiffDays = diffDays; // sets the difference as new maximum difference if it is larger than the previous value
    }
    return maxDiffDays; // returns the largest difference in days
}