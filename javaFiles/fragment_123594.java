import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class CombinationsOfVectors
{
    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList(1,2,3,5,6,7);

        ChoiceIterable<Integer> c = new ChoiceIterable<Integer>(3, input);
        for (List<Integer> v0 : c)
        {
            Set<Integer> s = new LinkedHashSet<Integer>(input);
            s.removeAll(v0);
            List<Integer> v1 = new ArrayList<Integer>(s);

            System.out.println(v0+" and "+v1);
        }
    }
}


// From https://github.com/javagl/Combinatorics/blob/master/src/
// main/java/de/javagl/utils/math/combinatorics/ChoiceIterable.java
// See the GitHub repo for a commented version
class ChoiceIterable<T> implements Iterable<List<T>>
{
    private final List<T> input;
    private final int sampleSize;
    private final long numElements;
    public ChoiceIterable(int sampleSize, List<T> input)
    {
        this.sampleSize = sampleSize;
        this.input = input;
        long nf = factorial(input.size());
        long kf = factorial(sampleSize);
        long nmkf = factorial(input.size() - sampleSize);
        long divisor = kf * nmkf;
        long result = nf / divisor;
        numElements = result;    
    }
    private static long factorial(int n)
    {
        long f = 1;
        for (long i = 2; i <= n; i++)
        {
            f = f * i;
        }
        return f;
    }    
    @Override
    public Iterator<List<T>> iterator()
    {
        return new Iterator<List<T>>()
        {
            private int current = 0;
            private final int chosen[] = new int[sampleSize];
            {
                for (int i = 0; i < sampleSize; i++)
                {
                    chosen[i] = i;
                }
            }
            @Override
            public boolean hasNext()
            {
                return current < numElements;
            }

            @Override
            public List<T> next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException("No more elements");
                }

                List<T> result = new ArrayList<T>(sampleSize);
                for (int i = 0; i < sampleSize; i++)
                {
                    result.add(input.get(chosen[i]));
                }
                current++;
                if (current < numElements)
                {
                    increase(sampleSize - 1, input.size() - 1);
                }
                return result;
            }

            private void increase(int n, int max)
            {
                if (chosen[n] < max)
                {
                    chosen[n]++;
                    for (int i = n + 1; i < sampleSize; i++)
                    {
                        chosen[i] = chosen[i - 1] + 1;
                    }
                }
                else
                {
                    increase(n - 1, max - 1);
                }
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException(
                    "May not remove elements from a choice");
            }
        };
    }
}