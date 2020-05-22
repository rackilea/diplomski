public List<Category> getCategoryList(int id) {
    List<Category> groupList;
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("select c from Category c join fetch c.events where c.parentCategory.categoryId = 1");
    //query.setParameter("id", id);
    groupList = query.list();
    return groupList;
}