public void process()
{
    int value = 1;
    int maxItterations = 8;
    int[] targetArray = new int[maxItterations];

    for(int index = 0; index < maxItterations; index++)
    {
        // Store current value
        targetArray[index] = value;

        // Duplicate the value for the next itteration
        value = value * 2;
    }
}