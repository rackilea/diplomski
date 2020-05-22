@Singleton
public class ProducersAlternative {
  @Produces @Named(PREFERENCES_FILE_NAMED) @Staging
  public String producePreferenceFileName(){
      return "preferences_test.xml";
  }
}