// from your example
// you can use injection here and everything, its a regular spring bean
@Service 
@Scope("prototype")
public class TraderStarter {
  private String address;

  public void setAddress(String address) {
      this.address = address;
  }   
}   

///////////////////////
@Component 
public class MyDbManager {

    private Provider<TraderStarter> traderStarterProvider; 

    public List<TraderStarter> dynamicallyCreateBeans() {
           List<String> addresses = dbManager.findAllAddresses();// to to the db, get the data
           return 
                addresses.stream()
                .map(this::createTraderStarter)  // <-- creates different beans! 

                .collect(Collectors.toList());
    }

    private TraderStarter createTraderStarter(String address) {
        TraderStarter ts = provider.get();
        ts.setAddress(address);
        return ts;
    }    
}