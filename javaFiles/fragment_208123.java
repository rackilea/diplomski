List<String> list = new ArrayList<String>();
list.add("aaa");
list.add("bbb");
list.add("aaa");

Set<String> unique = new HashSet<String>(list);
for (String key : unique) {
    System.out.println(key + ": " + Collections.frequency(list, key));
}