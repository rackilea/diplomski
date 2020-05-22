class Contributor implements Comparable<Contributor>{

    private String firstName;
    private String lastName;
    private String country;
    private String phone;
    private double contribution;
    private int id;

    public int compareTo(Contributor o) {
        return Integer.valueOf(id).compareTo(o.id);
    }
}

public class BinarySearch {
    /**
     * Performs a binary search for <code>key</code> in the list <code>l</code>.
     * 
     * @param l Ordered list of Contributors.
     * @param key Value to search for.
     */
    public void binarySearch(List<Contributor> l, Contributor key) {
        System.out.println("Binary search.");

        int upperBound = l.size();
        int lowerBound = 1;
        int midpoint = (upperBound + lowerBound) / 2;
        int difference = upperBound - lowerBound;

        for (int i = 0; i < l.size(); i++) {
            if (key.compareTo(l.get(midpoint - 1)) <0 ) {
                upperBound = midpoint - 1;
                midpoint = upperBound / 2;
            } else if (key.compareTo(l.get(midpoint - 1))>0 ) {
                lowerBound = midpoint + 1;
                midpoint = (lowerBound + upperBound) / 2;

            } else if (key.equals(l.get(midpoint - 1))) {
                midpoint = midpoint - 1;

                System.out.println("We found " + key + " at position "
                        + midpoint + " in the list.");
                i = l.size();
            } else {
                System.out.println("We couldn't find " + key + " in the list.");
                i = l.size();
            }
        }
    }
}