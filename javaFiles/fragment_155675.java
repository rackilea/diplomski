Random random = new Random();
String[] movies = {"The Shawshank Redemption (1994)",
   "The Godfather (1972)",
   "The Godfather: Part II (1974)",
   "The Dark Knight (2008)",
   "Pulp Fiction (1994)"};


// later somewhere else in a method or constructor...
int randomNumber = random.nextInt(movies.length);
String randomMovieTitle = movies[randomNumber];