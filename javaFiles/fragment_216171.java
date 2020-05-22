Comparator<Movie> comparator = new Comparator<Movie>() {
  @Override
  public int compare(Movie movie, Movie t1) {
    return movie.genre.compareTo(t1.genre);
  }
};

// ordered by genre
Collections.sort(movieList, comparator);    

// Reverse order by genre
Collections.sort(movieList, Collections.reverseOrder(comparator));