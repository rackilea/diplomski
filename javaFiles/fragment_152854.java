import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Range;

class Ranges
{
    // Computes the result of subtracting all the given ranges from
    // the given range.
    static <T extends Comparable<? super T>> List<Range<T>> subtractAll(
        Range<T> r, List<Range<T>> ranges)
    {
        List<Range<T>> currentList = Collections.singletonList(r);
        for (Range<T> other : ranges)
        {
            List<Range<T>> nextList = new ArrayList<Range<T>>();
            for (int i=0; i<currentList.size(); i++)
            {
                Range<T> current = currentList.get(i);
                List<Range<T>> differences = subtract(current, other);
                nextList.addAll(differences);
            }
            currentList = nextList;
        }
        return currentList;
    }

    // Computes the result of subtracting range r1 from
    // the given range r0. The result will be 
    // - an empty list if r1 encloses r0 
    // - an two-element list if r0 encloses r1
    // - a list containing r0 if the ranges are disjoint
    // - a single-element list otherwise 
    static <T extends Comparable<? super T>> List<Range<T>> subtract(
        Range<T> r0, Range<T> r1)
    {
        T min0 = r0.lowerEndpoint();
        T max0 = r0.upperEndpoint();
        T min1 = r1.lowerEndpoint();
        T max1 = r1.upperEndpoint();
        if (r0.encloses(r1))
        {
            List<Range<T>> result = 
                new ArrayList<Range<T>>();
            result.add(Range.closed(min0, min1));
            result.add(Range.closed(max1, max0));
            return result;
        }
        else if (r1.encloses(r0))
        {
            return Collections.emptyList();
        }
        else if (r0.isConnected(r1))
        {
            T min = null;
            T max = null;
            if (min0.compareTo(min1) < 0)
            {
                min = min0;
                max = min1;
            }
            else
            {
                min = max1;
                max = max0;
            }
            return Collections.singletonList(Range.closed(min, max));
        }
        return Collections.singletonList(r0);
    }

    // "Normalize" the given list of ranges: As long as two of
    // them are connected, they are replaced by their "span" (union)
    static <T extends Comparable<? super T>> List<Range<T>> normalize(
        List<Range<T>> ranges)
    {
        List<Range<T>> currentList = new ArrayList<Range<T>>(ranges);
        while (true)
        {
            List<Range<T>> toRemove = new ArrayList<Range<T>>();
            List<Range<T>> toAdd = new ArrayList<Range<T>>();
            for (int i=0; i<currentList.size(); i++)
            {
                for (int j=i+1; j<currentList.size(); j++)
                {
                    Range<T> r0 = currentList.get(i);
                    Range<T> r1 = currentList.get(j);
                    if (r0.isConnected(r1))
                    {
                        toRemove.add(r0);
                        toRemove.add(r1);
                        toAdd.add(r0.span(r1));
                    }
                }
            }
            if (toAdd.isEmpty())
            {
                break;
            }
            Set<Range<T>> set = new LinkedHashSet<Range<T>>();
            set.addAll(currentList);
            set.removeAll(toRemove);
            set.addAll(toAdd);
            currentList = new ArrayList<Range<T>>(set);
        }
        return currentList;
    }

}


class RangesContainer<T extends Comparable<? super T>>
{
    private List<Range<T>> ranges;

    RangesContainer()
    {
        ranges = new ArrayList<Range<T>>();
    }


    public List<Range<T>> add(Range<T> newRange)
    {
        if (ranges.stream().anyMatch(r -> r.encloses(newRange)))
        {
            return Collections.emptyList();
        }
        if (ranges.stream().noneMatch(r -> r.isConnected(newRange)))
        {
            ranges.add(newRange);
            ranges = Ranges.normalize(ranges);
            return Collections.singletonList(newRange);
        }
        List<Range<T>> differences = Ranges.subtractAll(newRange, ranges);
        ranges.add(newRange);
        ranges = Ranges.normalize(ranges);
        return differences;
    }


    List<Range<T>> getRanges()
    {
        return Collections.unmodifiableList(ranges);
    }

}

public class RangesTest
{
    static final LocalDateTime ZERO = 
        LocalDateTime.of(2015, 1, 1, 0, 0);

    public static void main(String[] args)
    {
        testCase0();
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
    }


    private static void testCase0()
    {
        System.out.println("Test case 0");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(45));

        rc.add(existing0);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(16),
            ZERO.plusMinutes(24));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }

    private static void testCase1()
    {
        System.out.println("Test case 1");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(4),
            ZERO.plusMinutes(45));

        rc.add(existing0);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(12));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }

    private static void testCase2()
    {
        System.out.println("Test case 2");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(6),
            ZERO.plusMinutes(45));

        rc.add(existing0);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(4));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }

    private static void testCase3()
    {
        System.out.println("Test case 3");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(41));

        rc.add(existing0);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(33),
            ZERO.plusMinutes(45));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }


    private static void testCase4()
    {
        System.out.println("Test case 4");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(39));

        rc.add(existing0);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(41),
            ZERO.plusMinutes(45));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }

    private static void testCase5()
    {
        System.out.println("Test case 5");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(17));
        Range<LocalDateTime> existing1 = Range.closed(
            ZERO.plusMinutes(30),
            ZERO.plusMinutes(45));

        rc.add(existing0);
        rc.add(existing1);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(21),
            ZERO.plusMinutes(25));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }


    private static void testCase6()
    {
        System.out.println("Test case 6");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(17));
        Range<LocalDateTime> existing1 = Range.closed(
            ZERO.plusMinutes(30),
            ZERO.plusMinutes(45));

        rc.add(existing0);
        rc.add(existing1);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(14),
            ZERO.plusMinutes(22));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }


    private static void testCase7()
    {
        System.out.println("Test case 7");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(17));
        Range<LocalDateTime> existing1 = Range.closed(
            ZERO.plusMinutes(30),
            ZERO.plusMinutes(45));

        rc.add(existing0);
        rc.add(existing1);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(25),
            ZERO.plusMinutes(33));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }

    private static void testCase8()
    {
        System.out.println("Test case 8");

        RangesContainer<LocalDateTime> rc = 
            new RangesContainer<LocalDateTime>();

        Range<LocalDateTime> existing0 = Range.closed(
            ZERO.plusMinutes(0),
            ZERO.plusMinutes(17));
        Range<LocalDateTime> existing1 = Range.closed(
            ZERO.plusMinutes(21),
            ZERO.plusMinutes(25));
        Range<LocalDateTime> existing2 = Range.closed(
            ZERO.plusMinutes(30),
            ZERO.plusMinutes(45));

        rc.add(existing0);
        rc.add(existing1);
        rc.add(existing2);

        Range<LocalDateTime> added = Range.closed(
            ZERO.plusMinutes(15),
            ZERO.plusMinutes(31));

        System.out.println("Existing:");
        print(rc.getRanges());

        System.out.println("Adding:");
        print("", added);

        List<Range<LocalDateTime>> returnValue = rc.add(added);

        System.out.println("Returned:");
        print(returnValue);

        System.out.println("Result");
        print(rc.getRanges());

        System.out.println("\n");
    }


    static void print(List<Range<LocalDateTime>> list)
    {
        for (int i=0; i<list.size(); i++)
        {
            Range<LocalDateTime> range = list.get(i);
            String message = String.format("%3d", i);
            print(message, range);
        }
    }

    static void print(String message, LocalDateTime t0, LocalDateTime t1)
    {
        long minutes0 = ZERO.until(t0, ChronoUnit.MINUTES);
        long minutes1 = ZERO.until(t1, ChronoUnit.MINUTES);
        System.out.printf("%10s:", message);
        for (long i=0; i<minutes0; i++)
        {
            System.out.print(" ");
        }
        for (long i=minutes0; i<minutes1; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    static void print(String message, Range<LocalDateTime> r)
    {
        print(message, r.lowerEndpoint(), r.upperEndpoint());
    }

}