public List<Post> getMostCommentedPosts(int page, int postsPerPage){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> p = cq.from(Post.class);
        cq.select(p).where(cb.isNotEmpty(p.get("comments")));
        List list = em.createQuery(cq).getResultList();
        for(Set each : list)
        {
            System.out.println(each.size());
        }

}