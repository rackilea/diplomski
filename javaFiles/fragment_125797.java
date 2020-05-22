public static void testing(List<Long> selected) {

    List<Contacts> contacts = new ArrayList<Contacts>();

    for (Long index : selected) {
        Contacts contact = contactService.findById(index);
        contacts.add(contact);
    }
    renderJSON(contacts);
}