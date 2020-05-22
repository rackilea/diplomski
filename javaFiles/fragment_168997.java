public static void main(String[] args) 
{
    double initialTuition = 10000;
    double summarizedTuition = 0;

    final double theRate = 0.05;

    for (int i = 1; i < 15; i++) {
        initialTuition = ((theRate * initialTuition) + initialTuition);
        System.out.println("Year " + i + " tuition is: " + initialTuition);

        if ((i > 10) && (i < 15)) 
        {
            summarizedTuition += initialTuition;
        }
    }

    System.out.println("Summarized tuition for years 11 - 14: " + summarizedTuition);
}