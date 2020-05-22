public class SomeClass {
 private String serviceNo;
 private String serDate;
 private String serMonth;
 private String serYear;
 private String serTime;
 private String serApartmentName;

 @JsonProperty("serviceNo") //to bind it to serviceNo attribute of the json string
 public String getServiceNo() {
  return serviceNo;
 }

 public void setServiceNo(String sNo) { //@JsonProperty need not be specified again
  serviceNo = sNo;
 }

 //create getter setters like above for all the properties.
 //if you want to avoid a key-value from getting parsed use @JsonIgnore annotation

}