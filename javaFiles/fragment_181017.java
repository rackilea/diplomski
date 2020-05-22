public class UnitTester{

@InjectMocks
private A aInstance;

@Spy
private Map mapSpy = new HashMap();

@Before
public void init(){
    MockitoAnnotations.initMocks(this);
}

@Test
public void test(){
    // Act   

    ainstance.method1();
    ainstance.method2();

    InOrder inOrder = inOrder(mapSpy);
    inOrder.verify(mapSpy).put("a", "A"));      
    inOrder.verify(mapSpy).put("b", "B"));     
}