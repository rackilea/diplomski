ArrayList<ArrayList> lists = new ArrayList<ArrayList>();

ArrayList<Integer> l = new ArrayList<Integer>();
l.add(1);
l.add(2);

ArrayList<String> l1 = new ArrayList<String>();
l1.add("hi");
l1.add("hello");

lists.add(l);
lists.add(l1);

for(ArrayList al : lists){

    for(Object o : al){
        System.out.println(o);
    }
}