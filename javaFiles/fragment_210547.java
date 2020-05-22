System.out.println("Please give alue for the table");
int value = scanner.nextInt();

scanner.nextLine(); // get rid of everything else left in the buffer

String[] StringArray = new String[value];

for (int i=0; i<value; i++)
{
    System.out.println("Please insert string for the position:"+(i+1));
    StringArray[i] = scanner.nextLine();
}