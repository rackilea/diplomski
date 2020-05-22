@ModelAttribute("command")
public Movie defaultInstance() {
    Movie movie = new Movie();
    movie.setFilmName("Rocky II");
    return movie;
}