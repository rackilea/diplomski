public static void main (String [] args)
{
double month, sum,monthweight;
sum = 0;
for (month = 1; month <= 12; month++)
    {

    monthweight = ConsoleInput.readDouble("Enter weight for each month");
    if(monthweight > 0.0M)
      {
        sum += monthweight;
      }
    else
     {
       break;
     }
    }
    System.out.println("Sum total is: " +sum);
}