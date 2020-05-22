@Path("/countries")
public class CountriesResource {

    CountriesService countriesService = new CountriesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<Countries> getCountries(){
            return countriesService.getCountries();
    }

    @Path("/{countryId}/news")
    public NewsResource getCountryNews(){
        return new CountryResource();
    }

}