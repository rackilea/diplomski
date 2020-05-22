@JsonIgnoreProperties(ignoreUnknown=true)
class Wrapper{


  @JsonProperty(value="filings")
  List<ExtractSECFilings> filings;

  public List<ExtractSECFilings> getFillings() {
    return filings;
  }

  public void setFillings(List<ExtractSECFilings> fillings) {
    this.filings = fillings;
  } 
}

@JsonIgnoreProperties(ignoreUnknown=true)
 class ExtractSECFilings {

 String id;
 String report_type;

public String getId() {
  return id;
}
public void setId(String id) {
  this.id = id;
}
public String getReport_type() {
  return report_type;
}
public void setReport_type(String report_type) {
  this.report_type = report_type;
}
@Override
public String toString() {
  return "ExtractSECFilings [id=" + id + ", report_type=" + report_type + "]";
}
}

//here add this code in  your main application to serialize the json

public class Demo{
public static void main(String args[]){
 Wrapper wrapper=mapper.readValue(val, Wrapper.class);
    System.out.println(wrapper.getFillings());
}
}
```
in the console you can see that id and report type json node values