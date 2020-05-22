ArrayList<Person> people = new ArrayList();
// add a bunch of Person objects like we did above

for(int i = 0; i < people.size(); i++) {
    System.out.println("Found person: " + people.get(i).firstName);
}