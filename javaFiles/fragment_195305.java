public class CompareStringExNonNumericComparator implements Comparator<String> {

    private static String INVARIANT_LOCALE = "";
    private static int NO_OPTIONS = 0;

    @Override
    public int compare(String o1, String o2) {
        int compareStringExComparisonResult =
            Kernel32.INSTANCE.CompareStringEx(NO_OPTIONS, o1, o2);

        // CompareStringEx returns 1, 2, 3 respectively instead of -1, 0, 1
        return compareStringExComparisonResult - 2;
    }
}