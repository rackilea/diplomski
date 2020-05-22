List missing = new ArrayList(); // answer

for (int i = 0; i < list1.size(); ) {
    int offset = i;
    i += 16 * 1024;
    if (i > list1.size()) i = list1.size();
    Set chunk = new HashSet(list1.subList(offset, i));

    for (int j = list2.size(); --j >= 0; chunk.remove(list2.get(j));
    missing.addAll(chunk);
}