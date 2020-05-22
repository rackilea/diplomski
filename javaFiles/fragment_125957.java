public class PhoneBook
{
    private Map<String,Person> people = new HashMap<String,Person>();

    public void addPerson(String phoneNumber, Person person)
    {
        people.put(phoneNumber,person);
    }

    public void getPerson(String phoneNumber)
    {
        return people.get(phoneNumber);
    }
}