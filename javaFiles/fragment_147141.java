List<PackingListRow> list =
        Arrays.asList(new PackingListRow("1234", 1, 10), new PackingListRow("1234", 2, 5), new PackingListRow("1234", 1, 15));

List<PackingListRow> mergedList = new ArrayList<>();
for(PackingListRow p : list) {
    int index = mergedList.indexOf(p);
    if(index != -1) {
        mergedList.set(index, mergedList.get(index).merge(p));
    } else {
        mergedList.add(p);
    }
}

System.out.println(mergedList);