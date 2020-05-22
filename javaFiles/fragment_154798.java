public class TestValues {

    @InjectMocks 
    @Spy
    NameClass names;
    @Mock HelpingClass help;
    @Test
    public void testgetValues() throws Exception
    {
        doReturn(help).when(names).getHelpingClass();
        Mockito.when(help.getJSONFile()).thenReturn(json);
        ...
     }
   }