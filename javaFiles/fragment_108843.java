public class ContactCriteria {

    private Integer type;
    private Integer val;

    public Integer getType() {
        return type;
    }

    public Integer getVal() {
        return val;
    }

}

interface ContactDao {
   Optional<Contact> getContact(ContactCriteria criteria);
   List<Contact> getContacts(ContactCriteria criteria);
}