public interface MyOptions extends PipelineOptions {    
     @Description("Org Id")
     @Default.String("123-984-a")
     ValueProvider<String> getOrgId();
     void setOrgId(ValueProvider<String> orgID);   
}