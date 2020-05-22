package org.world.hello;

import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RoomTest {

    @Configuration
    //@ImportResource(value = {"path/to/resource.xml"}) if you need to load additional xml configuration
    static class TestConfig {
       @Bean
       public BottleCounter bottleCounter() {
        return Mockito.mock(BottleCounter.class);
       }

       @Bean
       public Room room(BottleCounter bottleCounter) {
         Room room = new Room();
         room.setBottleCounter(bottleCounter);
         //r.setNumBottles(3); if you need 3 in each test
         return room;           
       }
    }

    @Autowired
    private Room room;  //room defined in configuration with mocked bottlecounter

    @Test
    public void testThreeBottlesAreSeperatedByNewLines()
    {
        Mockito.when(b.countBottle(Mockito.anyInt())).thenReturn("a");
        r.setNumBottles(3);
        assertEquals("a\na\na\na\n", r.generatePoem());
    }

}