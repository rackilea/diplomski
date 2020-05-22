public String getDispatch() {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
        context.getExternalContext().dispatch("/FacesClientServlet");
    } catch (IOException e) {
        throw new FacesException(e);
    }
    return null;
}