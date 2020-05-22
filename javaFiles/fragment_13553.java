List<Tuple> newList = new ArrayList<>();
for(Tuple tuple : newNonZeros) {
    if(!newList.contains(tuple)) {
        newList.add(tuple);
    }
}