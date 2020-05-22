@Test
public void testListOfABC() throws DAOException {
    // Declare your DAO 


    List<ABC> lstABC = dao.yourFunction();

    // check if it is null
    assertNotNull(lstABC);

    // check if the returned list have enough values 
    assertEquals(lstABC.size(), 3);

    // check if each value is corrected 
    assertEquals(lstABC.get(0).getName(), "firstname");
    assertEquals(lstABC.get(0).getAGE(), 25);
    // and so on   

}