// In your class that updates the book
Book uBook = records.get(BOOK_ID_YOU_WANT_TO_UPDATE);

// In the Book class
public void addCriticScore(String criticName, Integer score) {
  this.results.put(criticName, score);
}