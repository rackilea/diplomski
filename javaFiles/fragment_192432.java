if (!movieList.containsKey(string)) {
   throw new MovieListException("Movie not found");
}
//Rest of the code

//Or using Optional
Rating rating = Optional.ofNullable(movieList.get(string))
        .orElseThrow(() -> new MovieListException("Movie not found"));
Integer value = rating.getRating();