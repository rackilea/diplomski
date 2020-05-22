public String accountNumber() {
    String date = new Account().date();
    String name = new Customer().name();

    String account = date + ", " + name;
    return account;
}