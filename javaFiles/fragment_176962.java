@Aggregate
class MovieRating {

  @AggregateIdentifier
  private MovieRatingsId movieRatingsId;

  // the related movie
  private MovieId movieId;

  private Rating rating;

  // omitted handlers, getters and setters
}