int array1[] = new int[8];
int i7;
System.out.println("Type 8 numbers.");
array1[0] = keyboard.nextInt();

int smallest = array1[0]

for (i7 = 1; i7 < array1.length; i7++)
{
   array1[i7] = keyboard.nextInt();

   if (array1[i7] < smallest)
   {
       smallest = array1[i7];
   }
}
System.out.println("The smallest number is " + smallest);