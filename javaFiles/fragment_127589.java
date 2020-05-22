@Test
public void saveOneTest(){
    // you have already told Mockito to return this session instance when sessionFactory.getCurrentSession() is 
    // invoked so now your when (and optionally verify) should focus on session rather than on sessionFactory
    when(session.save(persona)).thenReturn(persona.getId());

    Persona persona_ = personaHibernateRepository.saveOne(persona);
    assertThat(persona_, is(persona));

    verify(session).save(persona);
}