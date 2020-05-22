public static void main(String[] args){
    ArrayList<Human> group = new ArrayList<Human>();
    group.add(new Male());
    group.add(new Female());
    // ... add more...

    // tell the class to take a pee break
    for (Human person : group) person.goPee();
}