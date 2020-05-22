@Route("show-movies")
public class MovieGUI extends VerticalLayout{
  MovieGUI(MovieRepository repo) {
    Grid<Movie> movieGrid = new Grid<>();
    movieGrid.setItems(repo.findAll());
    movieGrid.addColumn(Movie::getName).setHeader("Name");
    movieGrid.addColumn(Movie::getDescription).setHeader("Description");
    movieGrid.addComponentColumn(movie -> new NativeButton("Action", click-> doSomething(movie)).setHeader("");
    add(movieGrid);
  }
}