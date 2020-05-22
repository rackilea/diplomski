public void setContentType(String contentType) {
    if (Validator.isNull(contentType)) {
        throw new IllegalArgumentException();
    }

    Enumeration<String> enu = _portletRequestImpl.getResponseContentTypes();

    boolean valid = false;

    if (getLifecycle().equals(PortletRequest.RESOURCE_PHASE) ||
        _portletRequestImpl.getWindowState().equals(
            LiferayWindowState.EXCLUSIVE)) {

        valid = true;
    }