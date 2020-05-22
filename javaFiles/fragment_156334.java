class OpenResultsShould{
    @Test
    public void loadResults() {
        Data fake = mock (Data.class);
        ViewInterface view = mock(ViewInterface.class); // mocking view
        when(view.getFilename()).thenReturn("file.xml"); // we specify that when getFileName() method of view mock will be called "file.xml" string will be returned.

        ApplicationModelInterface appModel = mock(ApplicationModelInterface.class); // mocking app model
        when(appModel.getDataForView()).thenReturn(fake);

    OpenResultsAction openResults = new OpenResultsAction( view, appModel );

        openResults.actionPerformed(new ActionEvent());

        verify(view).getFileName();           // checks that view.getFileName was called within actionPerdormed()
        verify(appModel).load("file.xml");    // check that appModel.load( ) with file.xml as parameter was called within actionPerformed()
        verify(appModel).getDataForView();    // similar to above
        verify(view).loadDataFromModel( fake ); // finally I check if loadDataFromModel on view was called.
    }
}