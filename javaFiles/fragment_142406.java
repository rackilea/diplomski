public static void main (String [] args)throws Exception
        {
            Scanner sf = new Scanner(new FileInputStream("prog415h.dat"));
    int[] number = new int[100];
    int count = 0;
    Runner runner = new Runner();
            while(sf.hasNextLine())
                {
            number[count] = sf.nextInt();

            System.out.println("The orginal set of numbers are: " + number[count] + " ");
            count++;
        }
        runner.setNumbers(number);
        runner.Repeat();
    }
}

class Runner
{
    public static int[] numbers;
    public static void setNumbers(int[] numbers)
    {
        Runner.numbers = numbers;
    }
    public static void Repeat()
    {
        Set<Integer> uniqueElements = new HashSet<Integer>();
        System.out.println("List of Unique elements"); 
        for (int i = 0; i < numbers.length; i++) 
        { 
            if(!uniqueElements.contains(numbers[i]))
            {
                uniqueElements.add(numbers[i]);
                System.out.println(numbers[i]);
            }
        } 
        System.out.println();
    }
}