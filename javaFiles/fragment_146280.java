public class UserTest {

 @Mock
 private ShoppingCard shoppingCard;
 private User sut = new User();

 @Before
 public void setUp(){
    MockitoAnnotations.initMocks(this);
 }


 @Test
 public void shouldReturnUsersEmptyListWhenCardsEmpty(){
    //given
    when(shoppingCard.getShoppingCards()).thenReturn(Collections.emptyList());

    //when
    final List<User> result = sut.getUsers();

    //then
    assertEquals(0, result.size());
 }
}