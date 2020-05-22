public class CompareStringExNumericComparator implements Comparator<String> {

    private static int SORT_DIGITSASNUMBERS = 0x00000008;

    @Override
    public int compare(String o1, String o2) {
        int compareStringExComparisonResult =
            Kernel32.INSTANCE.CompareStringEx(SORT_DIGITSASNUMBERS, o1, o2);

        // CompareStringEx returns 1, 2, 3 respectively instead of -1, 0, 1
        return compareStringExComparisonResult - 2;
    }
}