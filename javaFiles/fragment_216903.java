em.getTransaction().begin();
em.persist(group);
em.getTransaction().commit();
em.close();

// reinit em
...

// load group from DB and afterwards close em
em.close();
...
// following throws LazyInitializationException :)
group.getAppUsers().iterator().next();