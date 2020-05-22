@Test
public void hiringWorksAsItShould() throws Exception {
    GroupManager gm = mock(GroupManager.class);

    gm.hire(developer); // YOU ARE CALLING THE MOCK HERE THEN!!
    assertThat(developer.getSupervisor()).isInstanceOf(GroupManager.class);
}