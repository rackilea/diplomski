@Test
public void testCreateTwoDifferentEMF() {
    Map properties1 = new HashMap();
    EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MyPu", properties1);
    Map properties2 = new HashMap();
    properties2.put("javax.persistence.jdbc.user", "foo");
    EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("MyPu", properties2);
    assertFalse(emf1 == emf2); //passes
}