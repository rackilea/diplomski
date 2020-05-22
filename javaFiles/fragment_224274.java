@LocalClient
public class PersonServiceTest extends AbstractTest {

    @Test
    public void testPersonService() {
        RemotePersonService mockRemotePersonService = Mockito.mock(RemotePersonService.class);
        List<Person> customResults = new ArrayList<Person>();
        customResults.add(new Person("Alice"));
        customResults.add(new Person("Bob"));
              Mockito.when(mockRemotePersonService.getAllPersons()).thenReturn(customResults);
        PersonService personService = new PersonServiceImpl(mockRemotePersonService);
        long count = personService.countPersons();    
        Assert.assertEquals(count, 2l);
    }
}