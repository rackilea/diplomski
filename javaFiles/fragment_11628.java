Integer val = hmap.get(new Character(c));
if (val != null && c != ' ') {
    hmap.put(c,  new Integer(val + 1));
}
else {
    hmap.put(c, 1);
}