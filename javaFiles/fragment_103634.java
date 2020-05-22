public void setStartData() {
    Contact contact = new Contact("Luiggi", "Mendoza", 12345);
    List<Contact> lstContact = new ArrayList<Contact>();
    lstContact.add(contact);
    ObjectOutputStream out = null;
    try {
        out = new ObjectOutputStream(new FileOutputStream("Rep.txt"));
        out.writeObject(lstContact);
        out.flush();
    } catch (IOException e) {
        System.out.println("Error while saving data.");
        e.printStackTrace(System.out);
    } finally {
        if (out != null) {
            out.close();
        }
    }
}