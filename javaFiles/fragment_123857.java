public void init() throws IOException {
    if (information == null) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/otherpage.xhtml");
    }
}