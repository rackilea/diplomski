Scanner kb = new Scanner(System.in).useDelimiter(" *");
System.out.println("Enter numbers delimited with a white-space:  ");
while (kb.hasNextInt()) {
    int x = kb.nextInt();
    System.out.println(x);
}