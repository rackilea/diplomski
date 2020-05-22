public static double[] bubbleSort(double[] mess){
    // Copy the array    
    double[] tidy = Arrays.copyOf(mess, mess.length);

    // sort
    for(int i=0; i<tidy.length; i++)
    {
        for(int j=i + 1; j<tidy.length; j++)
        {
            if(tidy[i] > tidy[j])
            {
                double temp = tidy[i];
                tidy[i] = tidy[j];
                tidy[j] = temp;
            }
        }
    }
    return tidy;
}