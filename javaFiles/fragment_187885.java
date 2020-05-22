@JsonIgnoreProperties(ignoreUnknown = true)
public class JobParametersWrapper {

   private List<JobParameter> parameterDefinitions;

   public List<JobParameter> getParameterDefinitions() {
      return parameterDefinitions;
   }

   public void setParameterDefinitions(List<JobParameter> parameterDefinitions) {
      this.parameterDefinitions = parameterDefinitions;
   }
}