Person person = new Person();

String emails[] = tokens[5].split(",");
for(String email : emails) {
    person.addEmail(email);
}