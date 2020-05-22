public void init() throws IOException {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context.isValidationFailed()) {
        ExternalContext externalContext = context.getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/otherpage.xhtml");
    }
}