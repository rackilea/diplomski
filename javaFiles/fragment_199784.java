public ABC getABC(String id) {
     StringBuilder bf = new StringBuilder();
     bf.append("SELECT a from ABC a ");
     bf.append("WHERE a.id = :id ");
     return (ABC) em.createQuery(bf.toString())
             .setParameter("id", id)
             .getSingleResult();            
}