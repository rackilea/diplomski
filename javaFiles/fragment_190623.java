private final String ID_NUM;

public License(String lastName) {
    this.lastName = lastName;
    this.ID_NUM = generateIDNumber();
}