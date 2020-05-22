int[] intArray = new int[40];
int index = 0;
while (result.next())
{
    intArray[index] = result.getInt(1);
    index++;
}