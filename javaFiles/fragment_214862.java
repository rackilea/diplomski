System.out.print("Mode: ");
int[] dataCounted = new int[data.length]; // This array will hold the values that are the mode
int value = -1; // Value of the number you're testing for, not how many of the number there is
int index = 0; // Index for the dataCounted array
for (int i = 0; i < data.length; i++)
{
    value = data[i];
    int count = 0;
    for (int j = 0; j < data.length; j++)
    {
        if (data[j] == data[i])
        {
            count++;
        }
    }
    if (count == maxCount)
    {
        boolean used = false;
        for (int j = 0; j < index; j++) 
        {
            if (value == dataCounted[j]) 
            {
                used = true;
            }
        }

        if (!used) 
        {
            dataCounted[index++] = value;
            System.out.print(data[i] + ", ");
        }
    }
}