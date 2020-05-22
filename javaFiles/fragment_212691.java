public List<FacesMessage> getMessages() {
    List<FacesMessage> messages = new ArrayList<FacesMessage>();
    Iterator<FacesMessage> iter = FacesContext.getCurrentInstance().getMessages();
    while (iter.hasNext()) {
        messages.add(iter.next());
    }
    return messages;
}