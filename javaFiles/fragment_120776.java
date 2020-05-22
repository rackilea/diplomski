import java.util.*;
import java.time.*;

public class ToDoList 
{
    ToDoListEntry first;
    ArrayList<LocalDate> datesList = new ArrayList();
    ArrayList<String> results = new ArrayList();

    public ToDoList ()
    {
        first = null;
    }

    public void add(ToDoListEntry newTask)
    {
        if (first == null)
        {
            first = newTask;
        }
        else
        {
            ToDoListEntry zeiger = first;
            while (zeiger.next != null)
            {
                zeiger = zeiger.next;
            }
            zeiger.next = newTask;
        }
    }

    public void sortDates()
    {
        Collections.sort(datesList);
    }

    public void compareAndSort()
    {
        ArrayList<String> tempDates = new ArrayList();
        for(LocalDate lD:datesList)
        {
            tempDates.add(lD+"");
        }
        ArrayList<String> tempSorted = new ArrayList();
        for(String s:tempDates)
        {
            for(String a:results)
            {
                if(a.contains(s))
                {
                    if(!tempSorted.contains(a))
                    {
                        tempSorted.add(a);
                    }
                }
            }
        }

        results=tempSorted;
        for(String s:results)
        {
            System.out.println(s);
        }
    }

    public String print()
    {
        String result = "";
        if (first == null) 
        {
            result = "Empty list!\n";
            System.out.println(result);
        }
        else 
        {
            ToDoListEntry pointer = first;
            while (pointer != null) 
            {
                result += "Until " + pointer.date + " Task: "+ pointer.task +"\n";
                if(LocalDate.now().isBefore(pointer.date))
                {
                    results.add("Until " + pointer.date + " Task: "+ pointer.task);
                }

                datesList.add(pointer.date);
                pointer = pointer.next;
            }
        }
        return result;
    }

    public String printDates()
    {
        String dates = datesList.toString();
        System.out.println(dates);
        return dates;
    }
}