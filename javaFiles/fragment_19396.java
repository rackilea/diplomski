public class MarketManager {

     private volatile List<Market> markets = Collections.emptyList();

     private MarketManager() { 
     }

     public void refresh() { 
         marketList = //build a new market list
     }

     public List<Market> getMarkets() {
         return Collections.unmodifiableList(markets);
     }

     // ...
}