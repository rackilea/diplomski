public class AddressBook<T extends Contact>
{

  private List<T> contacts = new ArrayList<T>();

  public void addContact(T contact)
  {
    contacts.add(contact);
  }

}