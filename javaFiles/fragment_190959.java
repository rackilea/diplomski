TreeMap group = new TreeMap();

void newRow(String Parent,String Child) {

if(group.containsKey(Parent)) {

    //if Parent already in group return Arraylist of child
    ArrayList<String> al = (ArrayList<String>) group.get(Parent);

    //Add new Child to ArrayList
    al.add(Child);
}
else {
    ArrayList<String> al = new ArrayList<>();
    al.add(Child);

    //if new Parent add parent and its Child ArrayList
    group.put(groupname,al);
}

}