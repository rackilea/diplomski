class ApplicationModelShould{
    @Test
    public void loadModelFromFile() {
        XMLDocument xml = new XMLDocumentFake();
        XMLFileLoader xFileLoader = mock(XMLFileLoader.class);
        when(xFileLoader.load("file.xml").thenReturn( xml );
        ApplicationModelInterface appModel = new ConcreteApplicationModel( new FileLoaderFake() );

        appModel.load("plik.xml"); // it should call xFileLoader and then parse returned xml document.
        doReturn(xml).when(xFileLoader).load("plik.xml"); // verifies if xFileLoader returned xml when appModel.load called it's load method. 
       Data expectedResult = populateExpectedResults();
       assertEquals( appModel.getDataForView().equals( expectedResult ) );
    }
}