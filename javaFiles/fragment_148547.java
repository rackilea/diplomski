Scanner sc = new Scanner(System.in);
while (true) {
    System.out.print("Name: ");
    String nameS = sc.nextLine();
    if (nameS.isEmpty()) {
        break;
    }
    System.out.print("Student number: ");
    int numberS = sc.nextInt();
    sc.nextLine();//you need to add this line in your code
    System.out.println(numberS);
}