public static void main(String[] args) {
    AddressBook addr = new AddressBook();
    Persons firstOne = new Persons("first name","first lastname","123");

    //You will use it as parameter like this:
    addr.addPerson(firstOne);
    addr.addPerson(new Persons("second name", "second lastname","456"));
    addr.addPerson(new Persons("third name", "thirs last name","789"));
    addr.addPerson(new Persons("fourth name", "fourth last name","101112"));
}