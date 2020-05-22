List<PersonDetails> people = new ArrayList<PersonDetails>();

people.add(new PersonDetails(42, "Martin"));

for (PersonDetails p: people)
{
    System.out.println(p.getName());
}