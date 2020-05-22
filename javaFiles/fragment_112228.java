import java.util.ArrayList;

public class ContactList {

    public static void main(String[] args) {

        ArrayList<Contact> contacts = new ArrayList<>();

        PersonalContact personalContact1 = new PersonalContact("John", "1980-01-01");
        BusinessContact businessContact1 = new BusinessContact("theCompany", "The Company");

        contacts.add(personalContact1);
        contacts.add(businessContact1);

        for (Contact contact : contacts) {
            System.out.println(contact.displayContact());
        }
    }
}