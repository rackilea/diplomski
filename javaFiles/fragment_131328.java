@RunWith(MockitoJUnitRunner.class)
public class SomeServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SomeService underTest;

    @Test
    public void testGetObjectAList() {
        ObjectA myobjectA = new ObjectA();
        //define the entity you want the exchange to return
        ResponseEntity<List<ObjectA>> myEntity = new ResponseEntity<List<ObjectA>>(HttpStatus.ACCEPTED);
        Mockito.when(restTemplate.exchange(
            Matchers.eq("/objects/get-objectA"),
            Matchers.eq(HttpMethod.POST),
            Matchers.<HttpEntity<List<ObjectA>>>any(),
            Matchers.<ParameterizedTypeReference<List<ObjectA>>>any())
        ).thenReturn(myEntity);

        List<ObjectA> res = underTest.getListofObjectsA();
        Assert.assertEquals(myobjectA, res.get(0));
    }