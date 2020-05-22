public class XSSRequestProcessor extends TilesRequestProcessor {

    @Override
    protected boolean processValidate(HttpServletRequest request,
            HttpServletResponse response, ActionForm form, ActionMapping mapping)
            throws IOException, ServletException, InvalidCancelException {
        return super.processValidate(new XSSFilteredRequest(request), response, form, mapping);
    }

}