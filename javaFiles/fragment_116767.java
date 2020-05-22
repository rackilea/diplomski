import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class TestMockedIterator {

    private Collection<String> fruits;
    private Iterator<String> fruitIterator;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
        fruitIterator = mock(Iterator.class);
        when(fruitIterator.hasNext()).thenReturn(true, true, true, false);
            when(fruitIterator.next()).thenReturn("Apple")
            .thenReturn("Banana").thenReturn("Pear");

        fruits = mock(Collection.class);
        when(fruits.iterator()).thenReturn(fruitIterator);
    }

    @Test
    public void test() {
        int iterations = 0;
        for (String fruit : fruits) {
            iterations++;
        }
        assertEquals(3, iterations);
    }
}