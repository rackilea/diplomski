@ModelAttribute(value = "newMovie")
public Movie newMovie() {
    Movie movie = new Movie();
    movie.setName("Test");
    return movie;
}