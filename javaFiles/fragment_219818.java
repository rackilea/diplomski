import java.util.*;

class Test {
    public static void main(String[] args) {

        List<Movie> moviesAvailable;

        moviesAvailable = new LinkedList<Movie>();

        moviesAvailable.add(new Movie("Matrix",1999,new Genre("SciFi"),3));
        moviesAvailable.add(new Movie("Jurassic Park",1993, new Genre("SciFi"),4));
        moviesAvailable.add(new Movie("The conjuring",1993, new Genre("Horror"),4));

        moviesAvailable.stream().map(movie -> movie.getGenre().getName()).distinct().forEach(System.out::println);

    }
}

class Genre {
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public Genre (String name) {
        this.name = name;
    }

}

class Movie {
    private String name;
    private int year;
    private Genre genre;
    private int whatever;

    public Genre getGenre()
    {
        return this.genre;
    }

    public Movie (String name, int year, Genre genre, int whatever) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.whatever = whatever;
    }
}