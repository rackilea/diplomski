public void alreadyLoggedIn() throws IOException {
  if (loggedIn) {
    ExternalContext externalContext =
        FacesContext.getCurrentInstance().getExternalContext();
    externalContext.redirect(externalContext.getRequestContextPath()
        + "/welcome.xhtml");
  }
}