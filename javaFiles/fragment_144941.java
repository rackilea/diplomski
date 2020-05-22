TextLayout textLayout = new TextLayout( 
        text.getIterator(), 
        g.getFontRenderContext() 
);
Rectangle2D.Float textBounds = ( Rectangle2D.Float ) textLayout.getBounds();

g.drawString( text.getIterator(), 50, 50 );
// lets draw a bounding rect exactly around our text
// to be sure we calculated it properly
g.draw( new Rectangle2D.Float(
        50 + textBounds.x, 50 + textBounds.y,
        textBounds.width, textBounds.height
) );