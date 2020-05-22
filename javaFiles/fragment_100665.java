public class FlightComparator implements Comparator<String> {
    public int compare(String arg0, String arg1) {
        // both have numbers, compare them
        if (containsNumber(arg0) && containsNumber(arg0)) {
            Integer i1, i2; 
            try {
                i1 = getNumber(arg0);
            } catch (NumberFormatException ex) {
                return 1;
            }

            try {
                i2 = getNumber(arg1);
            } catch (NumberFormatException ex) {
                return -1;
            }

            return i1.compareTo(i2); 
        } else {
            // no numbers
            return arg0.compareTo(arg1);
        }
    }

    private boolean containsNumber(String string) {
        return string.matches(".*\\d+.*");
    }  

    private Integer getNumber(String string) throws NumberFormatException {
        return Integer.parseInt(string.replaceAll("\\D+",""));
    }
}