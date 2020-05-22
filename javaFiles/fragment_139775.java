...
String qlString = "SELECT x "
                + "FROM MyInfo x JOIN x.myInfoRequests b "
                + "WHERE x.status = :status AND b.dataA = :dataA";
List<MyInfo> result = em.createQuery(qlString)
                        .setParameter("status", "1")
                        .setParameter("dataA", "BIG")
                        .getResultList();