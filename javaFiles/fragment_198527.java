ArrayList al = new ArrayList();
// add elements to al, including duplicates
HashSet hs = new HashSet();
hs.addAll(al);
al.clear();
al.addAll(hs);