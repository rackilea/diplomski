public class PlanetTest {
    private final static int NUM_PLANETS = 8;

    @Test
    public void testIntegrity() {
        assertEquals(NUM_PLANETS, Planet.values().length);

        for (Planet planet : Planet.values()) {
            assertTrue("Wierd: Mass in kg is less than radius in m", 
                planet.getMass() > planet.getRadius());
            }
        }
    }