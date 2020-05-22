public Collection<Album> findByIdAuthor(Long idAuthor, HttpServletRequest request) {
    Collection<Album> album;
    try {
        album = em.createQuery("select a from Album a where a.author.id like :id").setParameter("id", idAuthor).getResultList();
    } catch(Exception e) {
        request.setAttribute("err", e.toString());
        return null;
    }
    return album;
}