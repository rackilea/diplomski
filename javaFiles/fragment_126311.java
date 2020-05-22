ProcessClass processClass = new ProcessClass();

Citizen citizen1 = mock(Citizen.class);
Citizen citizen2 = mock(Citizen.class);
Citizen citizen3 = mock(Citizen.class);

@Test
public void getByName_shouldReturnCorrectCitizen_whenPresentInList() {
    when(citizen1.getName()).thenReturn("Bob");
    when(citizen2.getName()).thenReturn("Alice");
    when(citizen3.getName()).thenReturn("John");

    processClass.addCitizen(citizen1);
    processClass.addCitizen(citizen2);
    processClass.addCitizen(citizen3);

    Assert.assertEquals(citizen2, processClass.getByName("Alice"));
}

@Test
public void getByName_shouldReturnNull_whenNotPresentInList() {
    when(citizen1.getName()).thenReturn("Bob");

    processClass.addCitizen(citizen1);

    Assert.assertNull(processClass.getByName("Ben"));
}