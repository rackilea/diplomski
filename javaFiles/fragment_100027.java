ArrayList al = new ArrayList();
// add elements to al, including duplicates
HashSet<EventDetails> hs = new HashSet<EventDetails>();
hs.addAll(al);
al.clear();
al.addAll(hs);