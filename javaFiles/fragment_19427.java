import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        List<JobsInterval> jobsIntervalList = new ArrayList<JobsInterval>();

        jobsIntervalList.add(new JobsInterval(4, 1));
        jobsIntervalList.add(new JobsInterval(1, 2));
        jobsIntervalList.add(new JobsInterval(3, 2));
        jobsIntervalList.add(new JobsInterval(0, 3));
        jobsIntervalList.add(new JobsInterval(2, 3));

        printPossibleCombinations(jobsIntervalList);
    }

    public static void printPossibleCombinations(List<JobsInterval> list)
    {
        //Assumes the list is already in interval order.
        int currentInterval = -1;
        List<List<JobsInterval>> outerList = new ArrayList<List<JobsInterval>>(list.size());
        List<JobsInterval> innerList = null;

        //Loop through the list and group them into separate lists by interval.
        for (JobsInterval ji : list)
        {
            if (ji.interval != currentInterval)
            {
                if (null != innerList)
                    outerList.add(innerList);

                currentInterval = ji.interval;
                innerList = new ArrayList<JobsInterval>(list.size());
            }

            innerList.add(ji);
        }

        if (null != innerList)
            outerList.add(innerList);

        print(0, outerList, null);
    }

    public static void permute(StringBuilder value, List<JobsInterval> list, List<String> permutations)
    {
        //Check to see if this is the last recursive call
        if (0 == list.size())
        {
            permutations.add(value.toString());
        }
        else
        {
            List<JobsInterval> subList;

            for (int i = 0; i < list.size(); i++)
            {
                subList = new ArrayList<>(list);
                subList.remove(i);
                permute(new StringBuilder(null == value ? "" : value).append(list.get(i).jobs), subList, permutations);
            }
        }
    }

    public static void print(int index, List<List<JobsInterval>> list, StringBuilder value)
    {
        //Check to see if this is the last recursive call
        if (list.size() == index)
            System.out.println(value.toString());
        else
        {
            List<JobsInterval> intervalGroup = list.get(index);
            List<String> permutations = new ArrayList<String>();

            permute(null, intervalGroup, permutations);

            for (String permutation : permutations)
                print(index+1, list, new StringBuilder(null == value ? "" : value).append(permutation));
        }
    }

    private static class JobsInterval
    {
        public int jobs;
        public int interval;

        public JobsInterval(int j, int i)
        {
            jobs = j;
            interval = i;
        }

        public String toString()
        {
            return new StringBuilder().append('{').append(jobs).append(", ").append(interval).append('}').toString();
        }
    }
}