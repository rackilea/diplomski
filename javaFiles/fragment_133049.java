Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        if (countA(o1) == countA(o2)) {
            if (o1.length() == o2.length()) {
                // Compare lexicographically
                return o2.compareTo(o1);
            }
            // Compare by the length
            return o2.length() - o1.length();
        }
        // Compare by the number of 'a'
        return countA(o2) - countA(o1);
    }

    private int countA(String s) {
        int total = 0;
        for (int pos = 0; pos < s.length(); ++pos) {
            if (s.charAt(pos) == 'a') {
                total++;
            }
        }
        return total;
    }
});