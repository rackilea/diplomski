public class SimpleStackVelocityView extends VelocityView {

    private final static String SEPARATOR = "/";

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {

        Long vendorid = RequestParameterResolver.getVendorID(request);
        Long siteid = RequestParameterResolver.getSiteID(request);

        /* This always gets the last part of the path.
         * So in this case it gets "template.vm"
         * as long as that is the last part of the path
        */
        String templateName = new File(getUrl()).getName();

        StringBuffer urlBuffer = new StringBuffer();

        if (vendorid != null) {
            urlBuffer.append(vendorid);
            urlBuffer.append(SEPARATOR);
        }

        if (siteid != null) {
            urlBuffer.append(siteid);
            urlBuffer.append(SEPARATOR);
        }

        urlBuffer.append(templateName);
        setUrl(urlBuffer.toString());

        super.exposeHelpers(model, request);
    }
}