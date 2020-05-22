/**
 * TextExtractor that makes source line and col references available
 * http://grepcode.com/file_/repo1.maven.org/maven2/net.htmlparser.jericho/jericho-html/3.3/net/htmlparser/jericho/TextExtractor.java/?v=source
 */
public class SourceTextExtractor {

    public static class TextResult {
        private String text;
        private Source root;
        private Segment segment;
        private int line;
        private int col;

        /**
         * get a textResult
         * @param root
         * @param segment
         */
        public TextResult(Source root,Segment segment) {
            this.root=root;
            this.segment=segment;
            final StringBuilder sb=new StringBuilder(segment.length());
            sb.append(segment);
            setText(CharacterReference.decodeCollapseWhiteSpace(sb));
            int spos = segment.getBegin();  
            line=root.getRow(spos);
            col=root.getColumn(spos);

        }

        /**
         * gets info about this TextResult
         * @return
         */
        public String getInfo() {
            int epos=segment.getEnd();

            String result=
                    " line "+   line+" col "+col+
                    " to "+
                    " line "+   root.getRow(epos)+" col "+root.getColumn(epos)+
                    ":"+getText();
            return result;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text) {
            this.text = text;
        }

        public int getLine() {
            return line;
        }

        public int getCol() {
            return col;
        }

    }

    /**
     * extract textSegments from the given html
     * @param html
     * @return
     */
    public List<TextResult> extractTextSegments(String html) {
        Source htmlSource=new Source(html);
        List<TextResult> result = extractTextSegments(htmlSource);
        return result;
    }

    /**
     * get the TextSegments from the given root segment
     * @param root
     * @return
     */
    public List<TextResult> extractTextSegments(Source root) {
        List<TextResult> result=new ArrayList<TextResult>();
        for (NodeIterator nodeIterator=new NodeIterator(root); nodeIterator.hasNext();) {
            Segment segment=nodeIterator.next();
            if (segment instanceof Tag) {
                final Tag tag=(Tag)segment;
                if (tag.getTagType().isServerTag()) {
                    // elementContainsMarkup should be made into a TagType property one day.
                    // for the time being assume all server element content is code, although this is not true for some Mason elements.
                    final boolean elementContainsMarkup=false;
                    if (!elementContainsMarkup) {
                        final net.htmlparser.jericho.Element element=tag.getElement();
                        if (element!=null && element.getEnd()>tag.getEnd()) nodeIterator.skipToPos(element.getEnd());
                    }
                    continue;
                }
                if (tag.getTagType()==StartTagType.NORMAL) {
                    final StartTag startTag=(StartTag)tag;
                    if (tag.name==HTMLElementName.SCRIPT || tag.name==HTMLElementName.STYLE ||  (!HTMLElements.getElementNames().contains(tag.name))) {
                        nodeIterator.skipToPos(startTag.getElement().getEnd());
                        continue;
                    }

                }
                // Treat both start and end tags not belonging to inline-level elements as whitespace:
                if (tag.getName()==HTMLElementName.BR || !HTMLElements.getInlineLevelElementNames().contains(tag.getName())) {
                    // sb.append(' ');
                }
            } else {
                if (!segment.isWhiteSpace())
                    result.add(new TextResult(root,segment));
            }
        }
        return result;
    }

    /**
     * extract the text from the given segment
     * @param segment
     * @return
     */
    public String extractText(net.htmlparser.jericho.Segment pSegment) {

        // http://grepcode.com/file_/repo1.maven.org/maven2/net.htmlparser.jericho/jericho-html/3.3/net/htmlparser/jericho/TextExtractor.java/?v=source
        // this would call the code above
        // String result=segment.getTextExtractor().toString();
        final StringBuilder sb=new StringBuilder(pSegment.length());
        for (NodeIterator nodeIterator=new NodeIterator(pSegment); nodeIterator.hasNext();) {
            Segment segment=nodeIterator.next();
            if (segment instanceof Tag) {
                final Tag tag=(Tag)segment;
                if (tag.getTagType().isServerTag()) {
                    // elementContainsMarkup should be made into a TagType property one day.
                    // for the time being assume all server element content is code, although this is not true for some Mason elements.
                    final boolean elementContainsMarkup=false;
                    if (!elementContainsMarkup) {
                        final net.htmlparser.jericho.Element element=tag.getElement();
                        if (element!=null && element.getEnd()>tag.getEnd()) nodeIterator.skipToPos(element.getEnd());
                    }
                    continue;
                }
                if (tag.getTagType()==StartTagType.NORMAL) {
                    final StartTag startTag=(StartTag)tag;
                    if (tag.name==HTMLElementName.SCRIPT || tag.name==HTMLElementName.STYLE ||  (!HTMLElements.getElementNames().contains(tag.name))) {
                        nodeIterator.skipToPos(startTag.getElement().getEnd());
                        continue;
                    }

                }
                // Treat both start and end tags not belonging to inline-level elements as whitespace:
                if (tag.getName()==HTMLElementName.BR || !HTMLElements.getInlineLevelElementNames().contains(tag.getName())) {
                    sb.append(' ');
                }
            } else {
                sb.append(segment);
            }
        }
        final String result=net.htmlparser.jericho.CharacterReference.decodeCollapseWhiteSpace(sb);
        return result;
    }
}