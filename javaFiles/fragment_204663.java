public class MyStringComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {

        int caseIgnoreResult = s1.compareToIgnoreCase(s2);
        if (caseIgnoreResult == 0) {
            return s1.compareTo(s2);
        }
        else {
            return caseIgnoreResult;
        }
    }
}