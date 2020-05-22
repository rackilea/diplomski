protected void findMail(String lname) {
    if (person.containsKey(lname)) {
        List<String> listMails = person.get(lname).stream()
                .map(Person::getMail)
                .collect(toList());
    }
}