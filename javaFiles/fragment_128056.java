public class RandomNumberGenerator {

    private int minimum;
    private int maximum;
    private Random random = new Random();
    private Set<Integer> hSet =  new HashSet<>();

    public RandomNumberGenerator(int min, int max)
    {
        minimum = min;
        maximum = max;
    }

    public void printRandomNumber()
    {
        int range =  maximum - minimum + 1; 
        int randomValue = 0; 

        do
        {
            randomValue =  minimum + random.nextInt(maximum - minimum + 1); 
        } while(!hSet.add(randomValue));

        System.out.println("The next random number is: " + randomValue);    
    }
}