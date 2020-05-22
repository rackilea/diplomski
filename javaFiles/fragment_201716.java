// This would, presumably, be a method on MovieList.
public List<String> getUppercaseTitles() {
    List<String> uppercaseTitles = new ArrayList<>();
    for (Movie movie : this.getMovies()) {
        uppercaseTitles.append(movie.getTitle().toUpper()); 
    }
    return uppercaseTitles;
}