public class MovieResultTransformer
        implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] tuple,
            String[] aliases) {
        Movie movie = new Movie();
        movie.setId((Long) tuple[0]);
        movie.setName((String) tuple[1]);
        movie.setReleaseDate((Date) tuple[2]);
        MovieCelebrity movieCelebrity = new MovieCelebrity();
        movieCelebrity.setCharacterName((String) tuple[3]);
        movie.getMovieCelebrities().add(movieCelebrity);
        return movie;
    }

    @Override
    public List transformList(List collection) {
        Map<Long, Movie> movies = new LinkedHashMap<>();
        for (Object item : collection) {
            Movie movie = (Movie) item;
            Long id = movie.getId();
            Movie existingMovie = movies.get(id);
            if (existingMovie == null)
                movies.put(id, movie);
            else
                existingMovie.getMovieCelebrities()
                        .addAll(movie.getMovieCelebrities());
        }
        return new ArrayList<>(movies.values());
    }
}