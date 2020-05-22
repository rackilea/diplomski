// I'd like to be able to add both ints and strings to list
List<Object> list = new ArrayList<Object>();

list.add(new Integer(1));  

list.add(new String("b"));  

List<Gerbil> gerbillist = new ArrayList<Gerbil>();

for(int i = 0; i < 5; i++) {
    gerbillist.add(new Gerbil(i));
}

Collections.sort(gerbillist, new Comparator<Gerbil>() {
    public int compare(Gerbil o1, Gerbil o2) {
        int diff = o1.getNumber() - o2.getNumber();
        if (diff > 0)
           return 1;
        else if (diff <0)
           return -1;
        else
           return 0;
    }
});