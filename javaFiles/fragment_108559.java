@Test
@Transactional
public void shouldNotDeleteUnmappedRelations() throws Exception {

    session.purgeDatabase();
    session.query("CREATE (a1:A) CREATE (a2:A) CREATE (b:B{name:'b'}) CREATE (a1)-[:REL]->(b) CREATE (a2)-[:REL]->(b) RETURN id(b) as id", Collections.emptyMap());

    Collection<B> res = session.loadAll(B.class, new Filters("name", "b"), 0);
    B b = res.iterator().next();
    assertThat(b).isNotNull();

    session.save(b);
    session.clear();

    Collection<A> allA = session.loadAll(A.class);
    assertThat(allA).hasSize(2);
    assertThat(allA).extracting("b").isNotNull();
}