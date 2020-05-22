@Test
public void testdoGet() {
    //Initiate
    ReadyCheck readyCheck = new ReadyCheck();
    Writer writer = mock(Writer.class); //not sure which writer it is off the top of my head

    //Arange
    when(response.getWriter()).thenReturn(writer); //we pass the writer on the get
    when(response.getStatus()).thenReturn(HttpServletResponse.SC_OK); //we pass a status

    //Execute       
    readyCheck.doGet(request, response);

    //Verify
    verify(response, times(1)).setStatus(HttpServletResponse.SC_OK);
    verify(writer, times(1)).write("Ready!");
}