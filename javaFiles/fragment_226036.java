public class Cinema {

    private final String name;

    private List<Movie> currentMovieList;

    public Cinema(String name) {
        this.name = name;
        this.currentMovieList = new ArrayList<>();
    }

    public void addCurrentMovie0(Movie movie) {
        this.currentMovieList.add(movie);
    }

    public void removeMovie(Movie oldMovie) {
        for (int index = currentMovieList.size() - 1; index >= 0; index--) {
            Movie movie = currentMovieList.get(index);
            if (movie.getName().equals(oldMovie.getName())) {
                currentMovieList.remove(index);
            }
        }
    }

    public List<Movie> getCurrrentMovieList() {
        return Collections.unmodifiableList(currentMovieList);
    }

    public String getName() {
        return name;
    }

}