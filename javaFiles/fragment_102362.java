public static void main(String[] args) {
    // create two ArrayLists, first one containing lines, second containing desired objects
    List<String> websites = new ArrayList<String>();
    List<TestAllSitesTest> testAllSitesTests = new ArrayList<TestAllSitesTest>();

    // add csv lines to the first ArrayList
    websites.add("website1.uk, website1syndicator");
    websites.add("website2.uk, website2syndicator");
    websites.add("website3.uk, website3syndicator");

    // iterate the list containing the csv lines
    websites.forEach((String website) -> {
        // split one line into the desired two parts, eliminating comma and space
        String[] splitWebsite = website.split(", ");
        // create a new object passing the parts of the split line as constructor parameters
        TestAllSitesTest test = new TestAllSitesTest(splitWebsite[0], splitWebsite[1]);
        testAllSitesTests.add(test);
    });

    // print the resulting objects
    testAllSitesTests.forEach((TestAllSitesTest t) -> {
        System.out.println("Website: " + t.getWebsite()
                + ", Syndicator: " + t.getSyndicator());
    });
}