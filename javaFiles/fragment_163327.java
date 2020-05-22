import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Stack;

class StackMethodTesting {
    private Stack<Integer> aStackOfInt;

    @BeforeEach
    void initialize()
    {
        aStackOfInt = new Stack<Integer>();
        System.out.println(" a new Stack");
    }

    @Test
    void testpush() {
        Integer value = new Integer(1);
        aStackOfInt.push(value);
        assertTrue(aStackOfInt.peek().equals(value));
    }

    @Test
    void testPop() {
        Integer value = new Integer(22);
        aStackOfInt.push(value);
        assertEquals(value, aStackOfInt.pop());
    }
    @Test
    void testpeek()
    {
        Integer value = new Integer(222);
        aStackOfInt.push(value);
        assertEquals(value, aStackOfInt.peek());
    }


}