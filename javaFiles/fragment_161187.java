@Tranasctional
public boolean alreadyExists(String place) {
    List result = sessionFactory.getCurrentSession()
                         .createQuery("from Place where place_Name=:place")
                         .setParameter("place", place)
                         .list();
    return !result.isEmpty();
}