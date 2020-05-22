Scanner input = new Scanner(System.in);
for (int i = 0; i < month1.length; i++)
{
    System.out.println("Please enter the amount of vistors 2013-");
    month1[i] = input.nextInt();
}
for (int i = 0; i < month2.length; i++)
{
    System.out.println("Please enter the amount of vistors 2014");
    month2[i] = input.nextInt();
}
input.close();