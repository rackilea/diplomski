Map<Integer,Person> persons = new HashMap<Integer,Person>();
while(result.next()) {
    int id = result.getInt("id");
    Person p = persons.get(id);
    if (null == p) {
        p = new Person();
        // .. add all info to person (without phone number)
        persons.put(id,p);
    }
    p.moNumbers.add(result.getString("Mo_Number"));
}