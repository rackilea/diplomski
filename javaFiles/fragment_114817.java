abstract class AbstractSearchView<
     C extends AbstractCriteria,
     R extends AbstractResults,
     S extends AbstractService>
  public abstract DataStore<C, R, S> getResultsStore();
 } 
 class TravelSearchView extends AbstractSearchView<
     TravelCriteria, TravelResults, TravelService> {
   ...
 }