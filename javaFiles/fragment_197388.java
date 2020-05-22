public class CountryInfoResponse {

   @JsonProperty("geonames")
   private List<Country> countries; 

   //getter - setter
}

RestTemplate restTemplate = new RestTemplate();
List<Country> countries = restTemplate.getForObject("http://api.geonames.org/countryInfoJSON?username=volodiaL",CountryInfoResponse.class).getCountries();