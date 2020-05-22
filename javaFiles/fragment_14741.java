public static void oldest(String[] str, int[] ageInt)
{
    int maxAge=0;
    String maxName="";
    for(int i=0; i<ageInt.length;i++) // start from zero
    {
        if(ageInt[i]>maxAge) // compare to the current max
        {
            maxAge = ageInt[i];
            maxName = str[i];
        }
    }
    System.out.println("The listener "+maxName+ " is the oldest with an age "+maxAge);
}