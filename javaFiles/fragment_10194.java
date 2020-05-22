public class MovieRecommender {

  private Set<MovieCatalog> movieCatalogs;

  @Autowired
  // or if you don't want a setter, annotate the field
  public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
      this.movieCatalogs = movieCatalogs;
  }

  // ...
}