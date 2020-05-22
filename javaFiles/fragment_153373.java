@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "5")
public class PlayerTest {

    private Player player;
    private static PlayerService playerService;

    public PlayerTest (Player player) {
        this.player = player;
    }

    private static synchronized void initBeans() {
        if(context == null)
        {
            context = new AnnotationConfigApplicationContext("com.package.service");
        }
        playerService = context.getBean(PlayerServiceImpl.class);
    }

    @TestData
    public static Collection<Object[]> testData() {
        return playerService.getPlayers()
                .stream()
                .map(it -> new Object[]{it})
                .collect(Collectors.toList());
    }

    @Steps
    FeedsSteps feedsSteps;

    @Test
    @Title("Check player data")
    public void testPlayer() {
        feedsSteps.checkPlayer(player);
    }

}