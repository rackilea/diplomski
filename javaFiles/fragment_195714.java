@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("path/to/your/spring-config.xml")
public class MyTest {

    @Autowired
    FriendsDAO friendsDao;

    @Test
    public void testAddFriend() {
        final int rank = 1;
        Friends friend = new Friends();
        friend.setRank(rank);
        friendsDao.addFriend(friend);
        final long friendId = friend.getId();
        Friends insertedFriend = friendsDao.getFriend(friendId);
        Assert.assertEquals(insertedFriend.getRank(), friend.getRank());
        //assert if all necessary fields are equal
        //or assert if both are equals in case your Friends class implements equals method
    }
}