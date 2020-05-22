@RefreshScope
@Component
public class Test { 

    @Value("${conditional.istrue}")
    private boolean conditional;

    @Scheduled(fixedRateService = "120000")
    public void test(){
    if(conditional) {
      // do solution A
      } else {
      // do solution B
      }
    }   
}