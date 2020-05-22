public LineSegment getBaseline();    // the baseline for the text (i.e. the line that the text 'sits' on)
public LineSegment getAscentLine();  // the ascentline for the text (i.e. the line that represents the topmost extent that a string of the current font could have)
public LineSegment getDescentLine(); // the descentline for the text (i.e. the line that represents the bottom most extent that a string of the current font could have)
public float getRise()             ; // the rise which  represents how far above the nominal baseline the text should be rendered

public String getText();             // the text to render
public int getTextRenderMode();      // the text render mode
public DocumentFont getFont();       // the font
public float getSingleSpaceWidth();  // the width, in user space units, of a single space character in the current font

public List<TextRenderInfo> getCharacterRenderInfos(); // details useful if a listener needs access to the position of each individual glyph in the text render operation