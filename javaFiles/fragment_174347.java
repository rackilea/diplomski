List l = hmap.get(line);
if (l != null) {
     l.add(line));
}else {
     l = new ArrayList<String>();
     l.add(line)
     hmap.put(line, l);
}