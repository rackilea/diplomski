@RunWith(MockitoJUnitRunner.class)
public class CookieRepositoryTest {

@Mock
 EntityManager em;

@Mock
 TimeService timeService;

@InjectMocks
 CookieRepository underTest = new CookieRepository();

@Test
 public void testCreateEntity() throws Exception {
 Cookie newCookie = new Cookie();

when(timeService.getTime()).thenReturn(new DateTime(DateTimeZone.UTC));

doAnswer(new Answer<Brand>() {
 @Override
 public Brand answer(InvocationOnMock invocationOnMock) throws Throwable {
 Object[] args = invocationOnMock.getArguments();
 Cookie cookie = (Cookie) args[0];
 cookie.setId(1);
 return null;
 }

}).when(em).persist(any(Brand.class));

Cookie persistedCookie = underTest.createEntity(newCookie);
 assertNotNull(persistedCookie.getId());
 }

}