public class TestMarket {

    public static void main(String[] args) {
        Stock stock = new Stock(1f, 3f, 1f, 3f);

        MarketManager manager = new MarketManager();
        manager.setTarget(stock);
        manager.setName("Bad Publicity");
        manager.setModifier(-2f);
        manager.setModificationListener(new PublicOpinionModifier());

        manager.executeAction();
    }

}