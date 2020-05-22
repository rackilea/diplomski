Collections.sort(myObjectList, new Comparator<MyObject>(){
    @Override
    public int compare(MyObject o1, MyObject o2){
        String name1 = o1.getName();
        String name2 = o2.getName();

        if(name1 == null)
            name1 = "ZZZ"; // <- Last String in compareTo's order
        if(name2 == null)
            name2 = "ZZZ"; // <- Last String in compareTo's order

        return name1.compareTo(name2);
    }
});