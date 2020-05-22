public class ProfileImageDocx4jUserAgent extends Docx4jUserAgent {

    /**
     * Replace the image where the DisplayUserPic servlet is being called.
     * <p>
     * From overridden method javadoc:
     * <p>
     * {@inheritDoc}
     */
    @Override
    public Docx4JFSImage getDocx4JImageResource(String uri) {

        if (StringUtils.contains(uri, "DisplayUserPic")) {

            InputStream input = null;
            try {

                input = ...;
                byte[] bytes = IOUtils.toByteArray(input);
                return new Docx4JFSImage(bytes);

            } catch (IOException e) {
                getLogger().error(ExceptionUtils.getStackTrace(e));
            } catch (ServiceException e) {
                getLogger().error(ExceptionUtils.getStackTrace(e));
            } finally {
                IOUtils.closeQuietly(input);
            }

            return super.getDocx4JImageResource(uri);

        } else {
            return super.getDocx4JImageResource(uri);
        }
    }
}