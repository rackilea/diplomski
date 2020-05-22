public class Tokenize {

    static Long keysFromDB[] = {1L, 2L, 6L};
    static String stringsFromDB[] = {
        "BusinessPartner.name1,BusinessPartner.name2,BusinessPartner.name3,BusinessPartner.name4",
        "BusinessPartner.name1,BusinessPartner.name2,BusinessPartner.name3",
        "ADDRESS.addressline1,ADDRESS.addressline2,ADDRESS.addressline3"};

    @Test
    public void tokenize() {
        // use linked hashmap to preserve the order
        Map<Long, Set<String>> tokenized = new LinkedHashMap<Long, Set<String>>();
        int c = 0;
        for(Long key : keysFromDB) {
            // use linked hashset to preserve the order
            Set<String> record = new LinkedHashSet<String>();
            String splitedDBStrings[] = stringsFromDB[c++].split("\\.|,");
            System.out.println("List: " + Arrays.asList(splitedDBStrings));
            for(String s : splitedDBStrings) {
                record.add(s);
            }
            System.out.println("Set:  " + record);
            tokenized.put(key, record);
        }

        System.out.println(tokenized);
    }
}