@Test
public void resetServiceShouldResetGetMaxId(){
    service.reset();
    assertThat(service.getMaxId(), is(equalTo(0)));
}

@Test
public void getMaxIdShouldYieldLatestId(){
    int id = service.createFile("test.xml");
    int newMaxId = service.getMaxId();

    assertThat(id, is(equalTo(newMaxId)));
}

@Test
public void creatingFilesShouldYieldSuccessiveIDs(){
    int oldMaxId = service.getMaxId();
    int id = service.createFile("test.xml");

    assertThat(oldMaxId+1, is(equalTo(id)));
}