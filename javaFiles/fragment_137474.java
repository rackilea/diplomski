public void register() {
    FacesMessage fmessage;
    userb.encryptPassword();
    Message message = userEAO.create(userb.getUser());
    fmessage = new FacesMessage(message.getMessage());
    FacesContext.getCurrentInstance().addMessage(null, fmessage);
}