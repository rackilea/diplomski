public class Lab
{
    public static void main(String[] args)
    {
            String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", 
                "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"
            };

            int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265
            };



            int win = fastestIndex(times);
            int second = secondFastestIndex(times);
            System.out.printf("The fastest runner is: %s (%d Minutes)%n", names[win], times[win]);
            System.out.printf("The second fastest runner is: %s (%d Minutes)%n", names[second], times[second]);
    } // end main



    public static int fastestIndex(int[] times) 
    {

        int fastestIndex = 0;

        for (int counter = 0; counter < times.length; counter++)
        {

            if (times[counter] < times[fastestIndex]) 
            {
                fastestIndex = counter;
            }
        }

        return fastestIndex;

    }

    public static int secondFastestIndex(int[] times)
    {
        int fastestIdx = fastestIndex(times);
        int secondFastestIdx = 0;

        for (int counter = 0; counter < times.length; counter++)
        {
            //you search for the fastest, but you ignore it if it is
            // equal to the fastest index (so you are really finding the 2nd)
            if (times[counter] < times[secondFastestIdx] && counter != fastestIdx) 
            {
                secondFastestIdx = counter;
            }
        }

        return secondFastestIdx;
    }

} // end class Lab