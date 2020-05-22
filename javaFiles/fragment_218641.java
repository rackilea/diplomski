Scanner input = new Scanner(System.in);
input.useLocale(Locale.ENGLISH);
System.out.print("Enter a number: ");
while (!input.hasNextBigDecimal()) {
    System.out.print("Not a number, try again: ");
    input.next();
}
BigDecimal number = input.nextBigDecimal();
System.out.println(number);