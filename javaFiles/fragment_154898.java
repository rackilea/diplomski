Movie movie = Json.fromJson(jsonNode, Movie.class);

if(movies.stream().noneMatch(m -> m.getMovieName().equals(movie.getName()))) {
    movies.add(movie);
    return ok(Json.toJson(movie));
} else {
    // Movie name already exists... Throw exception here
    return badRequest("Movie already exists");
}