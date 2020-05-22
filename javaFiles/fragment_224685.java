@InjectMocks
private MyService _classUnderTest;

@Mock // or @Spy
private MyEntityTransform myEntityTransform;

@Before
public void prepare() {
    myEntityTransform.toEntity = mock(Function.class);
}