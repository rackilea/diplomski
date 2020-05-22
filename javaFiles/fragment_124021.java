public class TicketsPageController {
    private Film film;

    public Label filmName;
    public Label filmDescription;

    public void setFilm(Film film) {
        this.film = film;
        filmName.setText(film.getFilmTitle());
    }
}