List<Entry> toAdd = new ArrayList<Entry>();
Iterator it = mEntries.iterator();
while(it.hasNext()) {
  Entry e = it.next();

  if(e.getId().equals(someId)) {
    Entry newEntry = e.setData(newData);
    it.remove();
    toAdd.add(newEntry);
  }
}
mEntries.addAll(toAdd);