import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Tests {
    Partition sut = new Partition();

    @Test
    public void it_should_has_partition_size_2() {    
        ArrayList<ArrayList> partitioned = sut.partition(Arrays.asList(1,2,3,4),2);

        assertEquals(partitioned.size(), 2); // we expecting size to be 2
        assertEquals(partitioned.get(0), Arrays.asList(1,2,3)); // we know the first element should contains 1,2,3
    }

    @Test
    public void it_should_fail() {
        ArrayList<ArrayList> partitioned = main.partition(Arrays.asList(1,2,3,4),3);

        assertEquals(partitioned.size(), 2);
        // here it fails because we should expect partitioned.get(0) contains 1,2,3
        assertEquals(partitioned.get(0), Arrays.asList(1,2));
        /*
         * to pass this test we should use the below method
         * assertNotEquals(partitioned.get(0), Arrays.asList(1,2));
         */
    }
}