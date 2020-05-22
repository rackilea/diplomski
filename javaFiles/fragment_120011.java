int highestPriorityHospitalIndex(int[] a)
{
    for (int priority = 1; priority <= 7; priority++)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == priority && checkConditions(i))
            {
                return i;
            }
        }
    }
return -1;
}