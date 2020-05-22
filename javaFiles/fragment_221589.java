@PropertySource("classpath:config.properties")
 @ConfigurationProperties(prefix = "market")
 @Validated
 public class MarketConfig {
      List<MarketCurrency> currs;
      //getters setters

      public static class MarketCurrency {

          String name;
          String symbol;
        ....
//getters setters