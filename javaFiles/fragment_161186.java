@Tranasctional
public boolean alreadyExists(String place) {
    return sessionFactory.getCurrentSession()
                         .createQuery("from Place where place_Name=:place")
                         .setParameter("place", place)
                         .uniqueResult() != null;
}