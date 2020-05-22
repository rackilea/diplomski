int i = 0;
Integer[] array = new Integer[50];

while(console.hasNextInt() && i < 50)
{
   array[++i] = console.nextInt();
}