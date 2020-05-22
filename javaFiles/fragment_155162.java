import java.util.ArrayList;

public class ArrayTest {

    static int RUNS_INNER = 1000;
    static int RUNS_WARMUP = 10000;
    static int RUNS_OUTER = 100000;

    public static void main(String[] args) {
        long t1;
        long t2;

        Test test1 = new Test();
        test1.thing = (int)Math.round(100*Math.random());
        Test test2 = new Test();
        test2.thing = (int)Math.round(100*Math.random());

        for(int i=0; i<RUNS_WARMUP; i++)
        {
            testRefs(test1, test2);            
        }
        t1 = System.nanoTime();
        for(int i=0; i<RUNS_OUTER; i++)
        {
            testRefs(test1, test2);            
        }

        t2 = System.nanoTime();
        System.out.println((t2-t1)/1000000.0 + " How long NO collection");

        ArrayList<Test> list = new ArrayList<Test>(1);
        list.add(test1);
        list.add(test2);
        // tried this too: helps a tiny tiny bit 
        list.trimToSize();

        for(int i=0; i<RUNS_WARMUP; i++)
        {
            testColl(list);
        }
        t1= System.nanoTime();

        for(int i=0; i<RUNS_OUTER; i++)
        {
            testColl(list);
        }

        t2 = System.nanoTime();
        System.out.println((t2-t1)/1000000.0 + " How long collection");


        Test[] array = new Test[2];
        list.toArray(array);

        for(int i=0; i<RUNS_WARMUP; i++)
        {
            testArr(array);            
        }
        t1= System.nanoTime();

        for(int i=0; i<RUNS_OUTER; i++)
        {
            testArr(array);
        }

        t2 = System.nanoTime();
        System.out.println((t2-t1)/1000000.0 + " How long array ");

    }

    private static void testArr(Test[] array)
    {
        for (int i=0; i<RUNS_INNER; i++) {
            for (Test test : array) {
                test.changeThing(i);
            }
        }
    }

    private static void testColl(ArrayList<Test> list)
    {
        for (int i=0; i<RUNS_INNER; i++) {
            for (Test eachTest : list) {
                eachTest.changeThing(i);
            }
        }
    }

    private static void testRefs(Test test1, Test test2)
    {
        for (int i=0; i<RUNS_INNER; i++) {
            test1.changeThing(i);
            test2.changeThing(i);
        }
    }
}

class Test {
    int thing;
    int thing2;
    public void changeThing(int addThis) {
        thing2 = addThis + thing;
    }
}