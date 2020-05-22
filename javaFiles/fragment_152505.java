int[] array = { 0, 1, 2, 3 };
int newArray = new int[array.length + 1];

newArray[0] = 0;
for(int i = 1; i < newArray.length; i++)
{
   newArray[i] = array[i - 1];
}