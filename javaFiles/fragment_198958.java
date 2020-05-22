@Override
public Iterator<Tuple2<Integer, String>> call(String row) throws Exception {
    String[] split_row = row.split(",");
    //create list
    List<Tuple2<Integer, String>> result = new ArrayList<>()
    for(int j = 0; j<split_row.length;j++) {
        if(split_row[j].matches(int_regex)) {
            result.add(new Tuple2(j, "int"));
        } //else ...
    }
    //return the iterator
    return result.iterator();
}