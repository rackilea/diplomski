@RunWith(MockitoJUnitRunner.class)
public class ATest {        

    @Mock
    private X x;
    @Mock
    private Y y;


        @Spy
        @InjectMocks
        private B b;

        @Mock
        private C c;

        @InjectMocks
        A a; 

        @Before
        public void setUp() {
           MockitoAnnotations.initMock(this);
        }

    }