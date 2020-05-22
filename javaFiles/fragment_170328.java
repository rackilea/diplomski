public class test {


public static void main(String[] args)
{

    String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
            };

            int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
            };

            int fastest = Integer.MAX_VALUE;
    int slowestRunnner = 0;

            for (int i = 0; i < times.length; i++) {
                if(times[i] < fastest)
                {
                    fastest = times[i];
                    slowestRunnner = i;
                }
            }

            System.out.println(names[slowestRunnner]);
}
}

System.out.println(names[slowestRunner]);