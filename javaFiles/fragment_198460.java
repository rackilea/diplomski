@Component
@ConfigurationProperties(prefix = "dates")
public class Config{

   private List<String> fields = new ArrayList<String>();

   public List<String> getDateFields(){
      return this.fields;
   }
}