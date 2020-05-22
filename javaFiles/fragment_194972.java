package homework;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import com.locusenergy.homework.Elevator;

public class ElevatorTest extends EasyMockSupport{

    private Elevator elevator;

    @Before 
      public void setUp() {
        elevator = createMock(Elevator.class);
      } 

    @Test
    public void testCallElevator() {
        elevator.requestFloor(5);
    }
}