public class ContactServerResource extends ServerResource {
    @Get
    public Contact getContact() {
        String contactId = getAttribute("contactId");
        (...)
    }
}