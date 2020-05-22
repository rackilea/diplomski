public TaxPayer createUser(Scanner scan) {
    System.out.println("Say something");
    boolean x = scan.nextBoolean();
    ...
    return new TaxPayer(x,y,z);
}

public static void main(String...args) {
    Scanner scan = new Scanner(System.in);
    TaxPayer somebody = createUser(scan);
}