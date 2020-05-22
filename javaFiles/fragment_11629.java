if (c != ' ') {
    Integer val = hmap.get(new Character(c));
    if (val != null) {
        hmap.put(c,  new Integer(val + 1));
    }
    else {
        hmap.put(c, 1);
    }
}