@Configuration
public class AppConfig{

  @Bean
  public Robot robot1(IHand sonyH){
    return new Robot(sonyH);
  }

  @Bean
  public Robot robot2(IHand toshibaH){
    return new Robot(toshibaH);
  }

  @Bean(name = "sonyH")
  public SonyHand sonyHand(){
    return new SonyHand();
  }

  @Bean(name = "toshibaH")
  public ToshibaHand toshibaHand(){
    return new ToshibaHand();
  }
}