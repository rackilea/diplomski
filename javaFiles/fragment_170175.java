public class MovieRecommender {

    private CustomerPreferenceDao customerPreferenceDao;

    private MovieCatalog movieCatalog;

    //@Autowired - no longer necessary
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    @Autowired 
    public setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }
}