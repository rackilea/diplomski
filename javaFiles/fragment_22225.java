@Test // it passess when there's one object in repository (I assume u have clean memory db)
public void shouldPersistMyObject() throws Exception {
    em.persist(myObject);
    em.flush();
    Assert.assertThat(dao.findAll(), Matchers.equalTo(1));
}

@Test(expected = <YourDesiredException>.class) // if <YourDesiredException> is thrown, your test passes
public void shouldThrowExceptionWhenSavingCorruptedData() {
    //set NULL on some @NotNull value, then save, like:
    myObject.setUserId(null);
    em.save(myObject); //exception is thrown
}