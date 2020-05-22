private List<List<String>> jdata = new LinkedList<>();
String[] splitted;
.
.
splitted=(lines.split(";"));
LinkedList ll = new LinkedList(Arrays.asList(splitted));
jdata.add(ll);