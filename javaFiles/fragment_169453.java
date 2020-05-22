class Test {

    public static void main(String[] args) {

        // Create a map
        Map<String, Map<String, String>> twoDimMap =
                new HashMap<String, Map<String, String>>();

        // Fill it
        Map<String, String> innerA = new HashMap<String, String>();
        innerA.put("1", "A1");
        innerA.put("2", "A2");

        Map<String, String> innerB = new HashMap<String, String>();
        innerB.put("1", "B1");
        innerB.put("2", "B2");

        twoDimMap.put("A", innerA);
        twoDimMap.put("B", innerB);

        // Create an iterator for the values:
        Iterator<String> twoDimIter = new TwoDimIterator(twoDimMap);
        while (twoDimIter.hasNext())
            System.out.println(twoDimIter.next());

    }
}