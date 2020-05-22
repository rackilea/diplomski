Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
q.setParameter("id", id);
Object[] author = (Object[]) q.getSingleResult();

System.out.println("Author "
        + author[0]
        + " "
+ author[1]);