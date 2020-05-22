Scanner scan = new Scanner(System.in);

for (int counter = 0; counter < 1; counter++)
{
    // We don't need to assign defaults because these
    // variables will be assigned useful values before
    // they are used.
    double price;
    String name;
    // (other variables removed for simplicity)

    System.out.println("Enter price:     ");
    // Java is case-sensitive, make sure to use correct case.
    // The original "nextdouble" was incorrect.
    price = scan.nextDouble();

    System.out.println("Enter name:      ");
    name = scan.nextLine();

    // NOW use variables - AFTER they have useful values
    Phone phone = new Phone (.., .., price, name, .., ..);

    // Add new phone entry each loop,
    // not once at the end of all (1) loops.
    phoneList.add(phone);
}