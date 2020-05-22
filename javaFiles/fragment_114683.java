public PhoneBookEntry(String name, int number) {
    list = new LinkedList<PhoneBookEntry>();
    n = name;
    nr = number;
    list.add(new PhoneBookEntry(n, nr));
}