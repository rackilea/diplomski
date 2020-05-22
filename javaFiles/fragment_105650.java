@SpringJUnitConfig({RogueConfig.class, RewardsConfig.class})
public class CdiTest {

    @Test
    public void testCdiWithIdenticalBeans(@Autowired RewardNetwork rewardNetwork) {
        assertThat(rewardNetwork).isNotNull();
    }
}