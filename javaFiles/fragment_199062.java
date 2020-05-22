public class StrategyFactory {
    private List<GenericStrategy> strategy; 

    @Autowired
    public StrategyFactory(List<GenericStrategy> strategy) {
        this.strategy = strategy1;
    }

    public GenericStrategy getTrailerStrategy(String strategy) {
        LOGGER.info("Retrieving Strategy Class for {}", strategy);
        GenericStrategy result = null; 
        if (strategy.equals("CLOSE_DETAIL")) {
            result = getStrategy(Strategy1.class);
        } 
        else if(strategy.equals("LOAD_TRAILER")) {
            result = getStrategy(Strategy2.class);
        } 
        else if(strategy.equals("CLOSE_SUMMARY")) {
           result = getStrategy(Strategy3.class);
        } 
        else {
            throw new InvalidStrategyTypeException("Invalid Strategy Type");
        }

        if(result == null){
          throw new RuntimeException("Fail to load the strategy....");
        }
    }

    private <T> GenericStrategy getStrategy(Class<T> clazz){
        for(GenericStrategy s : strategy){
          if(clazz.isInstance(s)){
            return s;
          }
        }
        return null;
    }
}