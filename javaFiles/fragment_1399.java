public class PolynomialComparator implements Comparator<String> {

    private static Pattern pattern = Pattern.compile("([-+]\\d+)(\\w+)?");

    @Override
    public int compare(String s1, String s2) {
        if (s1 == null) throw new NullPointerException("s1");
        if (s2 == null) throw new NullPointerException("s2");

        int compare = 0;

        Matcher m1 = pattern.matcher(s1);
        Matcher m2 = pattern.matcher(s2);

        if (!m1.matches()) throw new IllegalArgumentException("Invalid Polynomial format: " + s1);
        if (!m2.matches()) throw new IllegalArgumentException("Invalid Polynomial format: " + s2);

        int n1 = Integer.parseInt(m1.group(1));
        int n2 = Integer.parseInt(m2.group(1));

        String p1 = m1.group(2);
        String p2 = m2.group(2);

        if (p1 == null && p2 == null) {  // Rule #1: just compare numbers
            compare = n2 - n1;
        } else if (p1 == null) {  // Rule #2: always sort number last
            compare = 1;
        } else if (p2 == null) {  // Rule #2: always sort non-number first
            compare = -1;
        } else {  // Rule #3: compare the letters
            compare = m1.group(2).compareTo(m2.group(2));
        }

        return compare;
    }
}