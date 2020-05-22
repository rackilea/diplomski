@Transactional
public void removeAll(){
    TypedQuery<anObject> query = em.createQuery(
            "DELETE FROM tableName",
            anObject.class);
    query.executeUpdate();
}