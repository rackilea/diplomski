public List<News> getAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<News> cq = cb.createQuery(News.class);
    Root<News> rootFromNews = cq.from(News.class);
    Join<News, NewsCategoryDict> join = rootFromNews.join("category"); // #1
    cq.select(rootFromNews);  // #2

    return em.createQuery(cq).getResultList();
}