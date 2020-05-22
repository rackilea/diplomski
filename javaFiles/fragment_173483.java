public void test() throws Exception {

    userTransaction.begin();

    try {
        entityManager.persist(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
        entityManager.persist(new Movie("Joel Coen", "Fargo", 1996));
        entityManager.persist(new Movie("Joel Coen", "The Big Lebowski", 1998));

        List<Movie> list = movies.getMovies();
        assertEquals("List.size()", 3, list.size());

        for (Movie movie : list) {
            movies.deleteMovie(movie);
        }

        assertEquals("Movies.getMovies()", 0, movies.getMovies().size());

    } finally {
        userTransaction.commit();
    }
}