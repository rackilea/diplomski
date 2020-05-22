String[] sarr = fdata.split(System.getProperty("line.separator"));
LinkedList<String> items = new LinkedList(Arrays.asList(sarr));

Set<String> filter = new HashSet<String>();
filter = new HashSet(Arrays.asList(voc.split(System.getProperty("line.separator"))));
items.retainAll(filter);