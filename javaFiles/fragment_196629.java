@RunWith(MockitoJUnitRunner.class)
public class MockTest {

private SimpleClass thing = Mockito.mock(SimpleClass.Class);

@Before
public void setup() {

    MockitoAnnotations.initMocks(this);  // need to enable these annotations programmatically
}

@Test
public void whenMethodsHaveSimilarSignatures() {

    when(thing.doWork(anyString(), anyString())).thenReturn(true);
    when(thing.doWork(any(Integer.class), anyString())).thenReturn(false);

 //or

   when(thing.doWork(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);
   when(thing.doWork(ArgumentMatchers.any(Integer.class), anyString())).thenReturn(false);

    assertThat(thing.doWork("one", "name")).isTrue();
    assertThat(thing.doWork(1, "name")).isFalse();
    }
 }