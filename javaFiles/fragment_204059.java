public class ImageToZkImageCoverter implements Converter<AImage, byte[], Image> {

    private Log logger = LogFactory.getLog(ImageToZkImageCoverter.class);

    @Override
    public byte[] coerceToBean(AImage compAttr, Image component, BindContext ctx) {
        logger.debug("Converting the image");
        return compAttr.getByteData();
    }

    @Override
    public AImage coerceToUi(byte[] beanProp, Image component, BindContext ctx) {
        try {
            if (beanProp != null && beanProp.length > 0) {
                AImage im = new AImage("", beanProp);
                component.setContent(im);
                logger.trace("Return an image, length = " + beanProp.length);
                return im;
            }
            logger.debug("Return null => image is empty");
            return null;
        } catch (IOException e) {
            logger.error("Error occured, returning null", e);
            return null;
        }
    }
}