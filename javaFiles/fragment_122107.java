String url = (something)
FacesContext fc = FacesContext.getCurrentInstance();
ExternalContext ec = fc.getExternalContext();
try {
        ec.redirect(url);
} catch (IOException ex) {
        Logger.getLogger(Navigation.class.getName()).log(Level.SEVERE, null, ex);
}