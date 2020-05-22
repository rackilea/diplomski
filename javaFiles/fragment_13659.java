String qlString = "SELECT AVG(x.price), SUM(x.stocks) FROM Magazine x WHERE ...";
Query q = em.createQuery(qlString);
Object[] results = (Object[]) q.getSingleResult();

for (Object object : results) {
    System.out.println(object);
}