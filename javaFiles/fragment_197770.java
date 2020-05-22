abstract class Account implements Serializable {
    protected String accountHolderName;
    protected long balance;

    protected transient ObjectOutputStream accData;

     transient Scanner input = new Scanner(System.in);
}