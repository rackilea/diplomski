public void writeCsv(List<MyTreeMap> list) {
    Set<String> ids = new TreeSet<String>();

    // ids will store all unique key in your example: a,b,c,d
    for(MyTreeMap m:list) {
        for(String id:m.keySet()) {
            ids.insert(id);
        }
    }

    // iterate ids [a,b,c,d] 
    for(String id:ids) {
        StringBuffer line = new StringBuffer();
        line.append(id);
        for(MyTreeMap m:list) {
            String pages = m.get(id);
            // pages will contains "1:4:7" like your example.
            line.append(",");
            line.append(pages);
        }
        System.out.println(line);
    }
}