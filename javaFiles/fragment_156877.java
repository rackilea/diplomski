public void externalLink() throws IOException {

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    // call external link
    String link = "http://www.google.com";
    ec.redirect(link); 
}