abstract class Account implements Serializable {
    protected String accountHolderName;
    protected long balance;

    //protected ObjectOutputStream accData;

    //Scanner input = new Scanner(System.in);
}

class Savings extends Account implements Serializable {

    Savings() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your name: ");
        accountHolderName = input.nextLine();
        System.out.print("\n");
        System.out.print("enter your balance: ");
        balance = input.nextLong();
        ObjectOutputStream accData = new ObjectOutputStream(new FileOutputStream(accountHolderName + ".bin"));
        accData.writeObject(this);
        accData.close();
    }
}