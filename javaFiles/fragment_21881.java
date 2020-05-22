@Test
public void test1()
{
    accept(em ->
    {
        Node n = new Node();
        em.persist(n);

        n.setName("node-1");
        n.setLabel("label-1");
    });
}