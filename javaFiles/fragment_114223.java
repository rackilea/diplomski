Scanner sc = new Scanner(System.in);
while (!sc.hasNextInt()) {
   System.out.println("int, please!");
   sc.nextLine();
}
int num = sc.nextInt();
System.out.println("Thank you! (" + num + ")");