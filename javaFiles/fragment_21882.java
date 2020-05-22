@Test
public void test2()
{
    accept(em ->
    {
        Node n = new Node();
        em.persist(n);
    });
}