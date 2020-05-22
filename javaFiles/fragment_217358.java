HTMLDocument htmlDoc = ...;
Element[] roots = htmlDoc.getRootElements(); // #0 is the HTML element, #1 the bidi-root
Element body = null;
for( int i = 0; i < roots[0].getElementCount(); i++ ) {
    Element element = roots[0].getElement( i );
    if( element.getAttributes().getAttribute( StyleConstants.NameAttribute ) == HTML.Tag.BODY ) {
        body = element;
        break;
    }
}
htmlDoc.insertAfterStart( body, "<font>text</font>" );