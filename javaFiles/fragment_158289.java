Collections.sort(myObjectList, new Comparator<MyObject>(){
    @Override
    public int compare(MyObject o1, MyObject o2){
        String name1 = o1.getName();
        String name2 = o2.getName();

        if(name1 == null && name2 == null)
            return 0;
        if(name1 == null) // && name2 != null
            return 10;
        if(name2 == null) // && name1 != null
            return -10;
        else // name1 != null && name2 != null
            return name1.compareTo(name2);
    }
});