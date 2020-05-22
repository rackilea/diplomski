public BankAccount() {
    System.out.println("Empty constructor called.");
    this.customer = "Nobody";
    this.number = 111111111111L;
    this.telephone = 18008888888L;
    this.email = "email@email.com";
    this.balance = 0.00;
}

public BankAccount (String customer, long number, long telephone, String email, double balance) {
    System.out.println("Constructor with parameters called.");
    this.customer = customer;
    this.number = number;
    this.telephone = telephone;
    this.email = email;
    this.balance = balance;
}