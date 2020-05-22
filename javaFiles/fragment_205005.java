public class PageVerticalAnalyzer extends PDFGraphicsStreamEngine {
    protected PageVerticalAnalyzer(PDPage page) {
        super(page);
    }

    public List<Float> getVerticalFlips() {
        return verticalFlips;
    }

    //
    // Text
    //
    @Override
    protected void showGlyph(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement)
            throws IOException {
        super.showGlyph(textRenderingMatrix, font, code, unicode, displacement);
        Shape shape = calculateGlyphBounds(textRenderingMatrix, font, code);
        if (shape != null) {
            Rectangle2D rect = shape.getBounds2D();
            addVerticalUseSection(rect.getMinY(), rect.getMaxY());
        }
    }

    /**
     * Copy of <code>org.apache.pdfbox.examples.util.DrawPrintTextLocations.calculateGlyphBounds(Matrix, PDFont, int)</code>.
     */
    private Shape calculateGlyphBounds(Matrix textRenderingMatrix, PDFont font, int code) throws IOException
    {
        GeneralPath path = null;
        AffineTransform at = textRenderingMatrix.createAffineTransform();
        at.concatenate(font.getFontMatrix().createAffineTransform());
        if (font instanceof PDType3Font)
        {
            // It is difficult to calculate the real individual glyph bounds for type 3 fonts
            // because these are not vector fonts, the content stream could contain almost anything
            // that is found in page content streams.
            PDType3Font t3Font = (PDType3Font) font;
            PDType3CharProc charProc = t3Font.getCharProc(code);
            if (charProc != null)
            {
                BoundingBox fontBBox = t3Font.getBoundingBox();
                PDRectangle glyphBBox = charProc.getGlyphBBox();
                if (glyphBBox != null)
                {
                    // PDFBOX-3850: glyph bbox could be larger than the font bbox
                    glyphBBox.setLowerLeftX(Math.max(fontBBox.getLowerLeftX(), glyphBBox.getLowerLeftX()));
                    glyphBBox.setLowerLeftY(Math.max(fontBBox.getLowerLeftY(), glyphBBox.getLowerLeftY()));
                    glyphBBox.setUpperRightX(Math.min(fontBBox.getUpperRightX(), glyphBBox.getUpperRightX()));
                    glyphBBox.setUpperRightY(Math.min(fontBBox.getUpperRightY(), glyphBBox.getUpperRightY()));
                    path = glyphBBox.toGeneralPath();
                }
            }
        }
        else if (font instanceof PDVectorFont)
        {
            PDVectorFont vectorFont = (PDVectorFont) font;
            path = vectorFont.getPath(code);

            if (font instanceof PDTrueTypeFont)
            {
                PDTrueTypeFont ttFont = (PDTrueTypeFont) font;
                int unitsPerEm = ttFont.getTrueTypeFont().getHeader().getUnitsPerEm();
                at.scale(1000d / unitsPerEm, 1000d / unitsPerEm);
            }
            if (font instanceof PDType0Font)
            {
                PDType0Font t0font = (PDType0Font) font;
                if (t0font.getDescendantFont() instanceof PDCIDFontType2)
                {
                    int unitsPerEm = ((PDCIDFontType2) t0font.getDescendantFont()).getTrueTypeFont().getHeader().getUnitsPerEm();
                    at.scale(1000d / unitsPerEm, 1000d / unitsPerEm);
                }
            }
        }
        else if (font instanceof PDSimpleFont)
        {
            PDSimpleFont simpleFont = (PDSimpleFont) font;

            // these two lines do not always work, e.g. for the TT fonts in file 032431.pdf
            // which is why PDVectorFont is tried first.
            String name = simpleFont.getEncoding().getName(code);
            path = simpleFont.getPath(name);
        }
        else
        {
            // shouldn't happen, please open issue in JIRA
            System.out.println("Unknown font class: " + font.getClass());
        }
        if (path == null)
        {
            return null;
        }
        return at.createTransformedShape(path.getBounds2D());
    }

    //
    // Bitmaps
    //
    @Override
    public void drawImage(PDImage pdImage) throws IOException {
        Matrix ctm = getGraphicsState().getCurrentTransformationMatrix();
        Section section = null;
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                Point2D.Float point = ctm.transformPoint(x, y);
                if (section == null)
                    section = new Section(point.y);
                else
                    section.extendTo(point.y);
            }
        }
        addVerticalUseSection(section.from, section.to);
    }

    //
    // Paths
    //
    @Override
    public void appendRectangle(Point2D p0, Point2D p1, Point2D p2, Point2D p3) throws IOException {
        subPath = null;
        Section section = new Section(p0.getY());
        section.extendTo(p1.getY()).extendTo(p2.getY()).extendTo(p3.getY());
        currentPoint = p0;
    }

    @Override
    public void clip(int windingRule) throws IOException {
    }

    @Override
    public void moveTo(float x, float y) throws IOException {
        subPath = new Section(y);
        path.add(subPath);
        currentPoint = new Point2D.Float(x, y);
    }

    @Override
    public void lineTo(float x, float y) throws IOException {
        if (subPath == null) {
            subPath = new Section(y);
            path.add(subPath);
        } else
            subPath.extendTo(y);
        currentPoint = new Point2D.Float(x, y);
    }

    /**
     * Beware! This is incorrect! The control points may be outside
     * the vertically used range 
     */
    @Override
    public void curveTo(float x1, float y1, float x2, float y2, float x3, float y3) throws IOException {
        if (subPath == null) {
            subPath = new Section(y1);
            path.add(subPath);
        } else
            subPath.extendTo(y1);
        subPath.extendTo(y2).extendTo(y3);
        currentPoint = new Point2D.Float(x3, y3);
    }

    @Override
    public Point2D getCurrentPoint() throws IOException {
        return currentPoint;
    }

    @Override
    public void closePath() throws IOException {
    }

    @Override
    public void endPath() throws IOException {
        path.clear();
        subPath = null;
    }

    @Override
    public void strokePath() throws IOException {
        for (Section section : path) {
            addVerticalUseSection(section.from, section.to);
        }
        path.clear();
        subPath = null;
    }

    @Override
    public void fillPath(int windingRule) throws IOException {
        for (Section section : path) {
            addVerticalUseSection(section.from, section.to);
        }
        path.clear();
        subPath = null;
    }

    @Override
    public void fillAndStrokePath(int windingRule) throws IOException {
        for (Section section : path) {
            addVerticalUseSection(section.from, section.to);
        }
        path.clear();
        subPath = null;
    }

    @Override
    public void shadingFill(COSName shadingName) throws IOException {
        // TODO Auto-generated method stub
    }

    Point2D currentPoint = null;

    List<Section> path = new ArrayList<Section>();
    Section subPath = null;

    static class Section {
        Section(double value) {
            this((float)value);
        }

        Section(float value) {
            from = value;
            to = value;
        }

        Section extendTo(double value) {
            return extendTo((float)value);
        }

        Section extendTo(float value) {
            if (value < from)
                from = value;
            else if (value > to)
                to = value;
            return this;
        }

        private float from;
        private float to;
    }

    void addVerticalUseSection(double from, double to) {
        addVerticalUseSection((float)from, (float)to);
    }

    void addVerticalUseSection(float from, float to) {
        if (to < from) {
            float temp = to;
            to = from;
            from = temp;
        }

        int i=0, j=0;
        for (; i<verticalFlips.size(); i++) {
            float flip = verticalFlips.get(i);
            if (flip < from)
                continue;

            for (j=i; j<verticalFlips.size(); j++) {
                flip = verticalFlips.get(j);
                if (flip < to)
                    continue;
                break;
            }
            break;
        }
        boolean fromOutsideInterval = i%2==0;
        boolean toOutsideInterval = j%2==0;

        while (j-- > i)
            verticalFlips.remove(j);
        if (toOutsideInterval)
            verticalFlips.add(i, to);
        if (fromOutsideInterval)
            verticalFlips.add(i, from);
    }

    final List<Float> verticalFlips = new ArrayList<Float>();
}