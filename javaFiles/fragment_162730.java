List<Issue2> issues=db.search("attributes/by_name_value")
    .limit(10).includeDocs(true)
    .query("name:\"web*\"", Issue2.class);

for (int i = 0; i < issues.size(); i++) {
    Issue2 row = issues.get(i);
    System.out.println("min_weight = " + row.getMin_weight());
    if (row.getAttributeCollection() != null && row.getAttributeCollection().getAttributeArray() != null) {
        for (int j=0; j<row.getAttributeCollection().getAttributeArray().length; j++) {
            String name = row.getAttributeCollection().getAttributeArray()[i].getName();
            String[] values = row.getAttributeCollection().getAttributeArray()[i].getValue();
            System.out.println(name);
            if (values != null) {
                for(String value: values) {
                    System.out.println(value);
                }
            }
        }
    }
}