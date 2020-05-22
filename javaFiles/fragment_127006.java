public static void printHistogram(int[]array) {
   //int[]array = {15,16,17,18,19};

    String[] day = {"mon","tue","wed","thur","fri"};
    System.out.println("Histogram of temperatures");
    System.out.println("-------------------------");
    for(int i=0;i < day.length;i++)
    {
        System.out.print(day[i]+"\t"+"|");
        for(int j=0;j< array[i]; j++)
                System.out.print("*");

        System.out.println();
    }
}