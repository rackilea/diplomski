import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.*;

public class TestRandomzingIterator
{
    @Test
    public void testRandomIteration()
    {
        final Set<String> set = new HashSet<String>()
        {
            /** Every call to iterator() will give a possibly unique iteration order, or not */
            @Nonnull
            @Override
            public Iterator<String> iterator()
            {
                return new RandomizingIterator<String>(super.iterator());
            }

            class RandomizingIterator<T> implements Iterator<T>
            {
                final Iterator<T> iterator;

                private RandomizingIterator(@Nonnull final Iterator<T> iterator)
                {
                    List<T> list = new ArrayList<T>();
                    while(iterator.hasNext())
                    {
                        list.add(iterator.next());
                    }
                    Collections.shuffle(list);
                    this.iterator = list.iterator();
                }

                @Override
                public boolean hasNext()
                {
                    return this.iterator.hasNext();
                }

                @Override
                public T next()
                {
                    return this.iterator.next();
                }

            /**
             * Modifying this makes no logical sense, so for simplicity sake, this implementation is Immutable.
             * It could be done, but with added complexity.
             */
            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("TestRandomzingIterator.RandomizingIterator.remove");
            }
            }
        };

        set.addAll(Arrays.asList("A", "B", "C"));

        final Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}