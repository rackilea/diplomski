public void testAsEmployee() throws Exception {
    Properties p = new Properties();
    p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
    p.put(Context.SECURITY_PRINCIPAL, "joe");
    p.put(Context.SECURITY_CREDENTIALS, "cool");

    InitialContext context = new InitialContext(p);

    try {
        movies.addMovie(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
        movies.addMovie(new Movie("Joel Coen", "Fargo", 1996));
        movies.addMovie(new Movie("Joel Coen", "The Big Lebowski", 1998));

        List<Movie> list = movies.getMovies();
        assertEquals("List.size()", 3, list.size());

        for (Movie movie : list) {
            try {
                movies.deleteMovie(movie);
                fail("Employees should not be allowed to delete");
            } catch (EJBAccessException e) {
                // Good, Employees cannot delete things
            }
        }

        // The list should still be three movies long
        assertEquals("Movies.getMovies()", 3, movies.getMovies().size());
    } finally {
        context.close();
    }
}