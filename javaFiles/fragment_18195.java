public class MyStringProducer {
  @Produces
  @Named("myString")
  public String getMyString() {
    return ...; // whatever you want ... read JSON, parse properties, randomize ...
  }
}