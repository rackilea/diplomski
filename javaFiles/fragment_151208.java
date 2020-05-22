public int searchPageNumber()
{
    XController xController = OODocument.getCurrentDocument().getXFrame().getController();

    XTextViewCursorSupplier supTextViewCursor =
                (XTextViewCursorSupplier) UnoRuntime.queryInterface(
                    XTextViewCursorSupplier.class, xController);

    XTextViewCursor curTextView = supTextViewCursor.getViewCursor();

    // gets the page cursor and assigns the text view cursor to the page
    XPageCursor curPage =
                (XPageCursor) UnoRuntime.queryInterface(
                    XPageCursor.class, curTextView);
    System.out.println("The current page number is " + curPage.getPage());

    // gets the model
    XModel model = xController.getModel();
    // assigns model to the document
    XTextDocument xTextDocument = (XTextDocument) UnoRuntime.queryInterface(XTextDocument.class, model);
    // Xsearchable so we can search the text
    XSearchable xSearchable = (XSearchable) UnoRuntime.queryInterface(XSearchable.class, xTextDocument); 
    XSearchDescriptor xsd = (XSearchDescriptor) xSearchable.createSearchDescriptor(); 

    xsd.setSearchString("zzzzz");

    XInterface xfi = (XInterface) xSearchable.findFirst(xsd); 
    if (xfi != null) { 
        XTextRange xStart = (com.sun.star.text.XTextRange) UnoRuntime.queryInterface( 
                com.sun.star.text.XTextRange.class, xfi); 

        curTextView.gotoRange(xStart, false); 
    } 

    System.out.println("current page = " + curPage.getPage());
    return curPage.getPage();
}