Map<String, List<Person>> groups = new HashMap<>();
List<Person> persons = groups.get("family");
if (persons == null) {
    persons = new ArrayList<>(25);
    groups.put("family", persons);
}
persons.add(aPerson);