@RunWith(MockitoJUnitRunner.class)
    public class fooTest {

        private Plane plane;

        @Mock
        private DomainService service;

        @Before
        public void setUp() {
            plane = new Plane();
            when(service.findObjectByID(any(Car.class))).thenReturn(plane);
        }
        [...]