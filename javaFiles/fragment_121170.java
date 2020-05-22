@PostConstruct
public void initialize() {
    data = service.select(id.getValue());
    if (data == null) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.setResponseStatus(HttpServletResponse.SC_NOT_FOUND);
            externalContext.dispatch("/404.xhtml");
            context.responseComplete();
        } catch (IOException ex) {
        }
    }
}