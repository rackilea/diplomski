// Used to sort movies by year
public int compareTo(Movies m) {
    Integer movie1 = Integer.valueOf(this.getYear());
    Integer movie2 = Integer.valueOf(m.getYear());
    return movie1.compareTo(movie2);
}