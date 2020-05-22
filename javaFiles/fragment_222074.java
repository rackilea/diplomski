Integer personAmount = mapOfSum.get(person.getId());
if (personAmount == null)
{
    personAmount = person.getAmount();
}
else
{
    personAmount = person.getAmount() + personAmount;
}
mapOfSum.put(person.getId(), personAmount);