public class MovieItem {
private double popularity;
private String photo;
private String name;

public MovieItem(double popularity, String poster_path, String original_title) {
    this.popularity = popularity;
    this.photo = photo;
    this.name = name;
}

public double getPopularity() { return popularity; }
public String getPhoto() { return photo; }
public String getName() { return name; }