public List<Person> createObjectsFromStringList(List<String> list) {

    List<person> personList = new Arraylist<>();
    //We use < size-2 here because we access 2 indeces ahead of x in this loop
    for(int x=0; x<list.size()-2; x+=3) { 
        personList.add(new Person(list.get(x), list.get(x+1), list.get(x+2));
    }
    return personList;
}