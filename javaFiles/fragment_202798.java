public class fooTest {

    private Plane plane;
    @Mock
    private Car car;

    @Before
    public void setUp() throws Exception {   
        MockitoAnnotations.initMocks(this);       
        plane = new Plane();
        plane.setId(2);
        plane.setColor(Color.BLUE);
        Mockito.when(car.findById(eq(plane.getId()))).thenReturn(plane);
    }

    @Test
    public void isBlue() {
       // There is no point in testing car since the result is already mocked.
        Plane result = car.findById(2);
        assertEquals(Color.BLUE, result.getColor());
    }
}