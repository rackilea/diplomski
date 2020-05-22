Scanner input = new Scanner(System.in);

System.out.println("How many grades are you putting? ");
int length = input.nextInt();
input.nextLine();

String[] gradesArray = new String[length];

for(int i = 0; i < gradesArray.length; i++)
{
    System.out.println("Enter grade (include + or -) ");
    gradesArray[i] = input.nextLine();
}