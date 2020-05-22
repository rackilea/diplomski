import java.util.*;
import java.time.*;

import java.util.*;
import java.time.*;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println("Test 00: Empty List");
        ToDoList list2016 = new ToDoList();

        list2016.print(); 

        System.out.println("Test 01: add");
        list2016.add(new ToDoListEntry(LocalDate.of(2016, 8, 15), "Do workout"));
        list2016.add(new ToDoListEntry(LocalDate.of(2015, 2, 18), "Hand in Homework"));
        list2016.add(new ToDoListEntry(LocalDate.of(2016, 6, 3), "Buy apples"));
        list2016.add(new ToDoListEntry(LocalDate.of(2016, 10, 11), "Read Books"));
        list2016.add(new ToDoListEntry(LocalDate.of(2016, 10, 11), "Read Homework"));

        list2016.print();
        list2016.sortDates();
        list2016.compareAndSort();
    }
}