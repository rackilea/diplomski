public Observable<List<Movie>> movies() {
  return moviesWithoutGenres()
    .switchMap(movies -> Observable.from(movies) // This is an Observable<Movie>
      .concatMap(movie -> movieGenres(movie)
        .first()
        .map(genres -> new Movie(movie.id, movie.title, genres)))
      .toList());
}