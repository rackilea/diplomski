class Contact{
    final String firstName;
    final String lastName;
    final int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Contact(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

@Test
public void sortTest(){
    List<Contact> contacts = new ArrayList<>();
    contacts.add(new Contact("A","B",37));
    contacts.add(new Contact("A","C",34));
    contacts.add(new Contact("B","A",35));

    Collections.sort(contacts, (Contact c1, Contact c2) -> {
        int firstNameComparisonResult = c1.getFirstName().compareTo(c2.getFirstName());
        if (firstNameComparisonResult != 0) {
            return firstNameComparisonResult;
        } else {
            return c1.getLastName().compareTo(c2.getLastName());
        }
    });

    System.out.println(contacts);
 //[Contact{firstName='A', lastName='B', age=37}, Contact{firstName='A', lastName='C', age=34}, Contact{firstName='B', lastName='A', age=35}]

}