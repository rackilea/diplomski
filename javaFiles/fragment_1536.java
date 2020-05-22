public void asd() throws SQLException {
    if(foo) {
        // do stuff
    } else {
        addInfoMessage("Eh. That's interesting.");
    }
}


private void addInfoMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
    FacesContext.getCurrentInstance().addMessage(null, message);
}