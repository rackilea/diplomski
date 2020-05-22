int k, m, g;
String n;
//double g;
Scanner input1 = new Scanner(System.in);
String[] Name = new String[5];
double[] Grade = new double[Name.length];
k = 0;
while (k < Name.length) {
    m = k + 1;
    System.out.print("Enter the name of student " + m + ": ");
    Name[k] = input1.nextLine();
    System.out.print("");
    System.out.print("Please enter the grade of student " + m + ": ");
    Grade[k] = input1.nextDouble();
    input1.nextLine();
    k++;
}