@Test
public void add_and_get() {
    Tom.addPet(Doggy); //will add doggy on to tom's arraylist
    assertEquals(Doggy, Tom.petList.get(0)); 
}

@Test
public void get_when_not_existing_returns_null() {
    assertNull(Tom.petList.get(0)); 
}