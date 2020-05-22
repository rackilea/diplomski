List<List> list1; 
list1.add(Arrays.asList(new int[2])); 
list1.add(Arrays.asList(new String[3])); 
list1.add(new ArrayList());
for (List e : list1){
    // no need to check instanceof Iterable because we guarantee it's a List
    for (Object object : e) {
        // ...
    }
}