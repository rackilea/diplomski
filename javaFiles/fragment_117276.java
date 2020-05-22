public List<Movie> findRange(int[] range) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
    Root<Movie> movie = cq.from(Movie.class);
    cq.select(movie);
    cq.order(cb.asc(movie.get(Movie_.getDate()));


    ...

}