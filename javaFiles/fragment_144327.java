@Test
public void test() { 

    Query query = mock(Query.class);

    when(entityManager.createNamedQuery(queryName)).thenReturn(query);

    ...