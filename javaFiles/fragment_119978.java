@Configuration
public class BarFactory
{
  @Bean
  public Bar createBar(MyHyperlinkListener mhl, int x) {
    return new Bar(mhl, x);
  }
}