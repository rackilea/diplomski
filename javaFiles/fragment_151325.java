public List<Person> createObjectsFromStringList(List<String> list) {

    List<person> personList = new Arraylist<>();
    int size = list.size();
    //Now we remove the "-2" from size check because we will handle this ourselves
    for(int x=0; x<size; x+=3) {
        String id = list.get(x); //Obviously valid
        String name = x+1 < size? list.get(x+1) : null;
        String address = x+2 < size? list.get(x+2) : null;
        personList.add(new Person(id, name, address);
    }
    return personList;
}