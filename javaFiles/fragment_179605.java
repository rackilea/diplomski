BooleanBuilder personClause = new BooleanBuilder();
for (Person person : personList)
{
    personClause.and(appointment.persons.contains(person));
}
query.where(personClause); // to add the clause