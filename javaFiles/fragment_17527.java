...
int[] shots = new int[CupsOfCoffee];
for (countd = 0; countd < CupsOfCoffee; countd++)
{
    System.out.println("How many coffee shots in cup " + (countd + 1));

    shots[countd] = keyboard.nextInt();
}
System.out.println("Order Suammery\n----------------");
for (countd = 0; countd < CupsOfCoffee; countd++)

System.out.println("cup " + (countd + 1) + " has " + shots[countd] +  " shots and will cost" ) ;