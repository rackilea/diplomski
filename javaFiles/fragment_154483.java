public String view(Contact contact) {
    this.contact = contact;
    contact.setAddresses(addressDAO.list(contact));
    contact.setPhones(phoneDAO.list(contact));
    return "view";
}