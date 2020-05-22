public ArrayList<String> conversion() {
    List<String> list = new ArrayList<String>();
    for (String retval : dwade.split(",")){
        list.add(retval);
    }
    return list;
}