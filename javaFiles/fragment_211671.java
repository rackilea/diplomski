Collections.sort(myList, new Comparator<Map<String,E extends Comparable>>(){

    @Override
    public int compare(Map<String,E extends Comparable> a, Map<String,E extends Comparable> b){
        return a.get("priority").compareTo(b.get("priority"));
        //alternative:
        //if(a.get("priority").equals(b.get("priority"))return 0;
        //if(a.get("priority") > (b.get("priority"))return 1;
        //return -1;
    }
})