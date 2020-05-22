public static void main(String[] args) {

    // Collection to store properties
    // You could also write a class to wrap this 
    // map along with the methods you need to implement
    // Say PropertyTable {
    //        private Map<Long, Property> properties ...
    //        Property getPropertyById(long id);
    //        getHighestPriced() // sort the map by price
    // }
    Map<Long, Property> properties = new HashMap<>();

    Path filepath = Paths.get("./data.csv");
    CSVReader reader = new CSVReader(filepath);
    for (CSVRow row : reader) {
        Iterator<String> it = row.iterator();
        Property p = new Property();
        p.setId(it.next());
        p.setAddress(it.next());
        // ... set the remaining properties
        p.setPrice(it.next(), new Locale("en", "GB"));
        p.seDateSold(it.next(), "MM/dd/yyyy");
        properties.put(p.getId(), p);
    }
    // At this point, you should have all the properties read

    // let's try to get property with id 5
    Property prop = properties.get(5L);
}