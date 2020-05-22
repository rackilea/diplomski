private final String message;
private final java.awt.geom.Rectangle2D.Float aboutMessageBounds;
private final AttributedString aboutMessageAttributedString;
private final AttributedCharacterIterator paragraph;


// The LineBreakMeasurer used to line-break the paragraph.
private java.awt.font.LineBreakMeasurer lineMeasurer;
// index of the first character in the paragraph.
private final int paragraphStart;
// index of the first character after the end of the paragraph.
private final int paragraphEnd;

@Override
public void init(){

    (...)

    java.util.Hashtable<TextAttribute, Object> textAtributMap = 
                new java.util.Hashtable<TextAttribute, Object>();

    textAtributMap.put(TextAttribute.FAMILY, "Serif");
    textAtributMap.put(TextAttribute.SIZE, new Float(26.0));
    textAtributMap.put(TextAttribute.JUSTIFICATION, TextAttribute.JUSTIFICATION_FULL );
    textAtributMap.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD );
    textAtributMap.put(TextAttribute.LIGATURES, TextAttribute.LIGATURES_ON );

    message = "This is a sample of a message.";

    aboutMessageAttributedString = new AttributedString( aboutMessage, textAtributMap );
    paragraph = aboutMessageAttributedString.getIterator();
    paragraphStart = paragraph.getBeginIndex();
    paragraphEnd = paragraph.getEndIndex();

    (...)

}

@Override
protected void paintComponent( Graphics g ) {
    super.paintComponent( g ); //To change body of generated methods, choose Tools | Templates.

    Graphics2D g2 = (Graphics2D)g.create();
        try {

            g2.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

            // Create a new LineBreakMeasurer from the paragraph.
            // It will be cached and re-used.
            if (lineMeasurer == null) {
                FontRenderContext frc = g2.getFontRenderContext();
                lineMeasurer = new java.awt.font.LineBreakMeasurer(paragraph, frc);
            }

            //You can scale it like I did. this part is not part of the code that I found.
            g2.scale( ratio.scaleDx, ratio.scaleDy );

            // Set break width to width of Component.
            //these were the measures I used for a something in a game;
            float breakWidth = 734.0f;
            float drawPosY = 90.0f;
            float posX0 = 30.0f;
            // Set position to the index of the first character in the paragraph.
            lineMeasurer.setPosition(paragraphStart);

            // Get lines until the entire paragraph has been displayed.
            while (lineMeasurer.getPosition() < paragraphEnd) {
                int next = lineMeasurer.nextOffset(breakWidth);

                int limit = next;
                if (limit <= message.length()) {
                    for (int i = lineMeasurer.getPosition(); i < next; ++i) {
                        char c = aboutMessage.charAt(i);
                        if (c == '\n') {
                            limit = i + 1;
                            break;
                        }
                    }
                }

                java.awt.font.TextLayout layout = lineMeasurer.nextLayout( breakWidth, limit, false );
                // Retrieve next layout. A cleverer program would also cache
                // these layouts until the component is re-sized.


                // Compute pen x position. If the paragraph is right-to-left we
                // will align the TextLayouts to the right edge of the panel.
                // Note: this won't occur for the English text in this sample.
                // Note: drawPosX is always where the LEFT of the text is placed.
                float drawPosX = layout.isLeftToRight()
                        ? posX0 : breakWidth - layout.getAdvance();
                // Move y-coordinate by the ascent of the layout.
                drawPosY += layout.getAscent();

                // Draw the TextLayout at (drawPosX, drawPosY).
                layout.draw(g2, drawPosX, drawPosY);

                // Move y-coordinate in preparation for next layout.
                drawPosY += layout.getDescent() + layout.getLeading();
            }

        } 
        finally {
            g2.dispose();
        }
}