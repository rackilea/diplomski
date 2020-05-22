static void selectionSort(int vals[], int curr_size)
{
    int temp;
    for(int i=0; i<curr_size - 1; i++)
    {
        int lowest = i;
        for(int j=i+1; j<curr_size; j++)
        {
            num_comps = num_comps + 1;
            if(vals[lowest] > vals[j] )
            {
                lowest = j;
            }
        }

        // swap lowest with current index
        temp = vals[lowest];
        vals[lowest] = vals[i];
        vals[i] = temp;
     }
}