private HashMap<Persoana,ArrayList<Account>>Unu; 

for (Entry<Persoana, ArrayList<Account>> entry : Unu.entrySet()) {
    for (Account account : entry.getValue() {
        if (account instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account;

            System.out.println("found "+savingsAccount.getIBAN());
        }
    }
}