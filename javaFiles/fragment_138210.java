while (someConditionIsTrue) {
    // create a Person passing some parameters
    Person p = new Person(miResultSet.getString("name"),
            miResultSet.getString("identification"));
    // create a PersonAction with the recently created person as parameter
    PersonAction pa = new PersonAction(p);
    // create the JButton passing the PersonAction as parameter
    JButton jb = new JButton(pa);
    // set the background of the JButton
    jb.setBackground(Color.YELLOW)));
    // add it to wherever it is to be added
    someThing.add(jb);
}