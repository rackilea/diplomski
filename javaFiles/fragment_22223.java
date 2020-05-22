public static void main(String[] args) {
        // Create a multi-map
        MultiMap<Site> multiMap = new MultiMap<>();

        // Add an index by Site.id
        MultiMapIndex<Integer, Site> byId = multiMap.addIndex((site)->site.id);

        // Add some entries to the map
        multiMap.add(new Site(1234,"A Site","A"));
        multiMap.add(new Site(4321,"Another Site","B"));
        multiMap.add(new Site(7777,"My Site","A"));

        // We can add a new index after the entries have been
        // added - this time by name.
        MultiMapIndex<String, Site> byName = multiMap.addIndex((site)->site.name);

        // Get a value by Id.
        System.err.printf("Get by id=7777 = %s\n", byId.get(7777));
        // Get a value by Name
        System.err.printf("Get by name='A Site' = %s\n", byName.get("A Site"));  

        // We can do usual mappy things with the indexes,
        // such as list the keys, or iterate over all entries
        System.err.printf("byId.keys() = %s\n", byId.keySet());
        byId.forEach((Integer id, Site s) -> System.err.printf("   %s => %s\n", id, s));

        // In some cases the map is not unique, so I provide a 
        // way to get all entries with the same value as a list.
        // in this case by their rating value.
        MultiMapIndex<String, List<Site>> byRating = multiMap.addMultiIndex((Site site)->site.rating);
        System.err.printf("byRating('A') = %s\n", byRating.get("A"));
        System.err.printf("byRating('B') = %s\n", byRating.get("B"));

        // Adding stuff after creating the indices is fine.
        multiMap.add(new Site(3333,"Last Site","B"));
        System.err.printf("byRating('A') = %s\n", byRating.get("A"));
        System.err.printf("byRating('B') = %s\n", byRating.get("B"));
    }
}