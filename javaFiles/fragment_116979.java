System.out.println("Day 1 you get 1 grain of rice for a total of 1 grain");
int sum = 1;
for (int i = 1; i <= days; i++)
{
 sum += Math.pow(2, i);
 System.out.println("Day " + (i + 1) + " you got " + (int)Math.pow(2,i) + 
     " grains of rice for a total of " + sum + " grains");
}