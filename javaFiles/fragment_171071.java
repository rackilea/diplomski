int array1[] = new int[8];
int i7;
int smallest;

System.out.println("Type 8 numbers.");

for (i7 = 0; i7 < array1.length; i7++)
{
   array1[i7] = keyboard.nextInt();

   if(i7 == 0)
   {
        smallest = array1[0];
   }
   else
   {
       if (array1[i7] < smallest)
       {
           smallest = array1[i7];
       }

   }
}
System.out.println("The smallest number is " + smallest);