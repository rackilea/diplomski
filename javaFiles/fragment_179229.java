if ( aURL.Path.compareTo("HelloWorld") == 0 )
{
    // add your own code here
    com.sun.star.frame.XController xController = m_xFrame.getController();
    if (xController != null) {
        XModel xModel = (com.sun.star.frame.XModel) xController.getModel();
        XTextDocument xTextDocument = (com.sun.star.text.XTextDocument)
            UnoRuntime.queryInterface(XTextDocument.class, xModel);
        XText xText = xTextDocument.getText();
        XTextRange xTextRange = xText.getEnd();
        xTextRange.setString( "Hello World (in Java)" );
        return;
    }
}