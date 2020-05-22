public Person(String name, String dob, Address address) {
    super();
    this.name = name; // <== important line
    this.dob = dob;  // <== important line
    this.address = address;  // <== important line
    LAST_ID ++;
    this.id = LAST_ID;

}