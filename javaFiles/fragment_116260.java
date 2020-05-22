@Test
public void creatingAFileTwiceShouldYieldDifferentIDs(){
    int id1 = service.createFile("test.xml");
    int id2 = service.createFile("test.xml");

    assertThat(id1, not(equalTo(id2)));
}

@Test
public void creatingFilesShouldYieldSuccessiveIDs(){
    int id1 = service.createFile("test1.xml");
    int id2 = service.createFile("test2.xml");

    assertThat(id1+1, is(equalTo(id2)));
}