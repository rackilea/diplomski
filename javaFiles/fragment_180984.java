@Mock
IDao daoMock;

@InjectMocks
MySubClass subclass;

@Before
public void init(){
  MockitoAnnotations.initMocks(this);
}

@Test
public void test(){
    subclass.toCreate();

    Mockito.verify(daoMock).create();
}