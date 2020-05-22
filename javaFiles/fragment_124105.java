private static int stringInListLength(List<String> list) {
    return list.stream().map(String::length).findFirst().orElse(0);
}

List<String> longestWords =
    Files.lines(Paths.get("alice.txt"))
         .collect(Collector.of(
             LinkedList::new,
             (List<String> list, String string) -> {
                 int stringLen = string.length();
                 int listStringLen = stringInListLength(list);
                 if (stringLen > listStringLen) {
                     list.clear();
                 }
                 if (stringLen >= listStringLen) {
                     list.add(string);
                 }
             },
             (list1, list2) -> {
                 int list1StringLen = stringInListLength(list1);
                 int list2StringLen = stringInListLength(list2);
                 if (list1StringLen > list2StringLen) {
                     return list1;
                 }
                 if (list2StringLen > list1StringLen) {
                     return list2;
                 }
                 list1.addAll(list2);
                 return list1;
             }
         ));