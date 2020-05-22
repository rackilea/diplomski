int largest = 0;
for (int i = 1; i < intList.length; i++)
{
    if (intList[i] > intList[largest])
    {
        largest = i;
    }
}
return largest;