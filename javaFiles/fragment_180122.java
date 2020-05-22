import java.util.ArrayList;

class Task
{
    public int taskLength;

    public Task(int taskLength)
    {
        this.taskLength = taskLength;
    }

    @Override
    public String toString()
    {
        return "T" + taskLength;
    }
}

public class Answers 
{   
    public static void main(String args[])
    {
        ArrayList masterList = new ArrayList();
        //Add some sample data
        masterList.add(new Task(555));
        masterList.add(new Task(1054));
        masterList.add(new Task(888));
        masterList.add(new Task(5923));
        masterList.add(new Task(2342));
        masterList.add(new Task(6243));
        masterList.add(new Task(9227));
        masterList.add(new Task(4111));
        masterList.add(new Task(4322));
        masterList.add(new Task(782));

        final int limit = 9999;

        ArrayList<Task> bestList = RecursivelyGetAnswer(new ArrayList<>(), masterList, new ArrayList<>(), limit, 0);

        System.out.println(bestList.toString());
        System.out.println(getTotal(bestList));
    }

    public static ArrayList<Task> RecursivelyGetAnswer(ArrayList<Task> listSoFar, ArrayList<Task> masterList, ArrayList<Task> bestList, int limit, int index)
    {
        for (int i = index; i < masterList.size(); i++)
        {
            Task task = masterList.get(i);
            if (getTotal(listSoFar) + task.taskLength <= limit)
            {
                listSoFar.add(task);
                if (getTotal(listSoFar) > getTotal(bestList))
                {
                    bestList = new ArrayList(listSoFar);
                }

                bestList = RecursivelyGetAnswer(listSoFar, masterList, bestList, limit, i+1);

                listSoFar.remove(task);
            }
        }

        return bestList;
    }

    // Given a list of tasks, get the sum of the lengths of the tasks.
    public static int getTotal(ArrayList<Task> myList)
    {
        int sum = 0;
        for (Task t:myList)
            sum += t.taskLength;
        return sum;
    }
}