@Override

protected IRequestCycleProcessor newRequestCycleProcessor() {

return new WebRequestCycleProcessor() {

    @Override
    protected IRequestTarget resolveBookmarkablePage(final RequestCycle requestCycle,
            final RequestParameters requestParameters) {
        IRequestTarget target = super.resolveBookmarkablePage(requestCycle, requestParameters);
        if(target == null) {
            return target;
        }
        if(target instanceof WebErrorCodeResponseTarget) {
            WebErrorCodeResponseTarget errorResponse = (WebErrorCodeResponseTarget) target;
            if(HttpServletResponse.SC_NOT_FOUND == errorResponse.getErrorCode()) {
                return null;
            }
        }
        return target;
    }

};