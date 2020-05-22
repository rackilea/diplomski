public class Movie implements Comparable<Movie> {

    private int id;
    private String name;
    private String directory;
    private double rating;

    public Movie(int id, String name, String directory, double rating) {
        this.id = id;
        this.name = name;
        this.directory = directory;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie o) {
        int diff = (int) asInt(getRating()) - asInt(o.getRating());
        if (diff == 0) {
            diff = getName().compareTo(name);
        }
        return diff;
    }

    protected int asInt(double value) {
        String text = Double.toString(value);
        text = text.replaceAll("\\.", "");
        return Integer.parseInt(text);
    }

    @Override
    public String toString() {
        return getId() + ", " + getName() + ", " + getDirectory() + ", " + getRating();
    }

}