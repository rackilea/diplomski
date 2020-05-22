public void randomStudy()
{
    int total = 0;
    int max = -1;
    int min = 11;
    int i = 0;
    Random ran = new Random();
    while (i < 1001)
    {
        for(int count = 1; count<=10;count++)
            count = ran.nextInt(11);

        if(total < min)
            min = total;
        if(total>max)
            max = total;

        System.out.println("Result of max: " + max);
        System.out.println("Result of min: " + min);
        double average = total/1000;
        System.out.println("Average: " + average);
        i++;
    }
}