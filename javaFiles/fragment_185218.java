public class ProfileImageDocx4jReplacedElementFactory extends Docx4jReplacedElementFactory {

    /**
     * Constructor.
     * 
     * @param outputDevice
     *            the output device
     */
    public ProfileImageDocx4jReplacedElementFactory(Docx4jDocxOutputDevice outputDevice) {
        super(outputDevice);
    }

    /**
     * Forces any images which use the DisplayUserPic servlet to be ignored.
     * <p>
     * From overridden method javadoc:
     * <p>
     * {@inheritDoc}
     */
    @Override
    public ReplacedElement createReplacedElement(LayoutContext layoutContext, BlockBox blockBox,
            UserAgentCallback userAgentCallback, int cssWidth, int cssHeight) {

        Element element = blockBox.getElement();
        if (element == null) {
            return null;
        }

        String nodeName = element.getNodeName();
        String src = element.getAttribute("src");
        if ("img".equals(nodeName) && src.contains("DisplayUserPic")) {
            return null;
        }

        // default behaviour
        return super.createReplacedElement(layoutContext, blockBox, userAgentCallback, cssWidth, cssHeight);
    }
}