public class BonusPoliticCardTest {

    @Test
    public void test() {
        PoliticCard politicCard = new PoliticCard();
        politicCard.setDeck();
        Bonus bonus = new BonusPoliticCard(3, politicCard);
        Player player = new Player(1);
        ((BonusPoliticCard) bonus).applyBonus(player);
        assertNotNull(player.getPoliticCards().get(2));
    }

}