package cart;

public class DVD {

    private String movie;
    private String rating;
    private String year;
    private Double price;

    public DVD(){}  

    public DVD(String movie, String rating, String year, Double price) {        
        this.movie = movie;
        this.rating = rating;
        this.year = year;
        this.price = price;
    }



    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DVD [movie=" + movie + ", rating=" + rating + ", year=" + year
                + ", price=" + price + "]";
    }

}