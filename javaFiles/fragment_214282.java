import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class MinTest<T extends Comparable<? super T>> {

    public List<T> list = new ArrayList<T>();
    public T min;

    public MinTest(T a, T b, T c) {
        this.list.add(a);
        this.list.add(b);
        this.min = c;
    }

    @Parameters
    public static Collection<Object[]> calcValues()
    {
        return Arrays.asList (new Object [][] {
            // Last value indicates expected value
            {1, 3, 1},
            {"a", "b", "a"}
        });
    }

    @Test
    public void minTest() {

        assertTrue("Single element list", min == Min.min(list));
    }
}