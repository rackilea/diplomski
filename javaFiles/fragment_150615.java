@RunWith(MockitoJUnitRunner.class)
public class MyAppTest
{
    @Mock
    private MyDao myDao;
    @Mock
    private PostSaveHandler postSaveHandler;

    @InjectMocks
    private MyApp myApp;

    @Test
    public void testMyMethod(){
        // given
        MyDomainClass myObj = new MyDomainClass();
        when(myDao.load(anyInt())).thenReturn(myObj);

        // when
        myApp.myMethod();

        ArgumentCaptor<MyDomainClass> argumentCaptor = ArgumentCaptor.forClass(MyDomainClass.class);
        verify(myDao).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().myInt, is(0));

        verify(postSaveHandler).handle(myObj);
    }
}