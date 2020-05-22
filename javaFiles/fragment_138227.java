while(scn.hasNext()) {
    String name = scn.next();
    int age = scn.nextInt();
    Person p = new Person(name, age);
    lst.add(p); // simply add to the end of the list
}