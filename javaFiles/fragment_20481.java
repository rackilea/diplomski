public class PostCountry {


    public String country;

    public PostCountry() {}

    public PostCountry(String country) {
        this.country = country;
    }

    public void setCountry(String country){
        this.country=country;
    }
    public String getCountry() {
        return country;
    }

}




@RequestMapping(value = "/getCountries"                                    
        , method = RequestMethod.POST                                      
        , consumes = "application/json"                                    
        , produces = "application/json")                                   
@ResponseBody                                                              
@JsonIgnoreProperties(ignoreUnknown = true)                                
public ReturnCountries getCountries(@RequestBody PostCountry country) {