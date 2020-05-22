public class ContactServerResource extends ServerResource {
    private Contact contact;

    @Override
    protected void doInit() throws ResourceException {
        String contactId = getAttribute("contactId");
        // Load the contact from backend
        this.contact = (...)
        setExisting(this.contact != null);
    }

    @Get
    public Contact getContact() {
        return contact;
    }

    @Put
    public void updateContact(Contact contactToUpdate) {
       // Update the contact based on both contactToUpdate
       // and contact (that contains the contact id)
    }

    @Delete
    public void deleteContact() {
       // Delete the contact based on the variable "contact"
    }
}