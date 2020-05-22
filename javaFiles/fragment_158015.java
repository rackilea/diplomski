@Configuration
public class E extends C<X> {

  @Bean("X)// Bean name qualifier
  @Override
  protected X b() {
    return super.b();
  }

  @Override
  protected X a() {
    return new X();
  }
}


@Configuration
public class F extends C<Y> {

  @Bean("Y") // Bean name qualifier
  @Override
  protected Y b() {
    return super.b();
  }

  @Override
  protected Y a() {
    return new Y();
  }
}