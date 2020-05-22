EntityGraph<MyClass> eg = em.createEntityGraph(MyClass.class);
eg.addAttributeNodes("id");
eg.addAttributeNodes("name");
eg.addAttributeNodes("relation");

Query q = em.createQuery("SELECT b FROM MyClass b");
q.setHint("javax.persistence.fetchgraph", eg);
List<MyClass> results = q.getResultList();