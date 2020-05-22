public class ComposeSMSList {

    private List<UserMessage> userMessages = null;
    private List<UserPhoneBook> userPhoneBooks = null;
    private List<UsersSendorId> usersSendorIds = null;
    private List<UserTemplate> userTemplates = null;

    public List<UserMessage> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(List<UserMessage> userMessages) {
        this.userMessages = userMessages;
    }

    public List<UserPhoneBook> getUserPhoneBooks() {
        return userPhoneBooks;
    }

    public void setUserPhoneBooks(List<UserPhoneBook> userPhoneBooks) {
        this.userPhoneBooks = userPhoneBooks;
    }

    public List<UsersSendorId> getUsersSendorIds() {
        return usersSendorIds;
    }

    public void setUsersSendorIds(List<UsersSendorId> usersSendorIds) {
        this.usersSendorIds = usersSendorIds;
    }

    public List<UserTemplate> getUserTemplates() {
        return userTemplates;
    }

    public void setUserTemplates(List<UserTemplate> userTemplates) {
        this.userTemplates = userTemplates;
    }
}