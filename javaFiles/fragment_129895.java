Person person = company.getPerson(id);
if(person != null) {
    Data data = person.getData();
    if(data != null) {
        String salary = data.getSalary();
        String postcode = data.getPostCode();
    }
}