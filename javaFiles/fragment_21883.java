@Test
public void test3()
{
    accept(em ->
    {
        Node n = new Node();
        n.setName("node-3");

        em.persist(n);

        n.setLabel("label-3");
    });

    Node n = apply(em -> em.createQuery("select x from Node x", Node.class).getSingleResult());

    Assert.assertEquals("label-3", n.getLabel());
}