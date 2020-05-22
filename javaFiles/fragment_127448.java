Scanner input = new Scanner(System.in);

System.out.println("\n");
System.out.print("Please Enter ID and hours-worked in a given week: ");
String enteredString = input.nextLine();

while (!enteredString.isEmpty()) {
    StringTokenizer stringtok = new StringTokenizer(enteredString, "+");
    String id = stringtok.nextToken();
    Double hours = Double.parseDouble(stringtok.nextToken());

    for (int i = 0; i < 5; i++) {
        if (worklist[i].getWorkerID().equals(id)) {
            worklist[i].addWeekly(hours);
            break;
        }
    }

    System.out.println("\n");
    System.out.print("Please Enter ID and hours-worked in a given week: ");
    enteredString = input.nextLine();
}

for (int i = 0; i < 5; i++) {
    worklist[i].gross();
    worklist[i].netAndTax();
    worklist[i].displaySalary();
}