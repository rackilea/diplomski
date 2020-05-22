import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<Movie>(5);
        movies.add(new Movie(1, "ABC", "Mr. xyz", 4.5));
        movies.add(new Movie(2, "GHI", "Mr. mno", 0));
        movies.add(new Movie(3, "DEF", "Ms. stu", 3));
        movies.add(new Movie(4, "AT1", "Mr. T", 3));

        System.out.println("Before....");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        Collections.sort(movies);

        System.out.println("After....");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

    }

    public static class Movie implements Comparable<Movie> {

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

}