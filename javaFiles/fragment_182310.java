List<Entry> entryList = new ArrayList();
 int entryCount = 0;
 Serializer serializer = new Persister();
 for (String[] row: dataList) {
   Entry entry = new Entry();
   entry.setTrader(row[1]);
   entry.setId(++entryCount);
   entryList.add(entry);
 }
 File result = new File("entries.xml");
 serializer.write(new Entries(entryList), result);