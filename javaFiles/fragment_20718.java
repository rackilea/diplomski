Iterator<Entry<String, List<String>>> iter = devNameType.entrySet().iterator();
while (iter.hasNext()) {
    Entry<String, List<String>> next = iter.next();
    List<String> value = next.getValue();
    System.out.println("key = " + next.getKey());
    System.out.println("values : ");
    for (String str : value) {
        System.out.println(str);
    }
}