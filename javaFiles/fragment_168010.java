// 1. Split `formatedString` as a List of Persons by `,`
ArrayList PersonList = new ArrayList(Arrays.asList(formatedString.split(",")));
// 2. Walk through the list of persons
for (int i = 0; i < PersonList.size(); i++) {
    // 3. Split the same `formatedString` in fields ?!?
    // What should happen here?
    // II think this is your problem        
    String []value=formatedString.split(",");
    insertPerson(value[0], value[1], value[2], value[3], value[4]);
    System.out.println(PersonList.toString());
}