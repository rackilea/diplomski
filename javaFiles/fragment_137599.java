public class BackingBean implements Serializable {
    private HtmlDataTable userTable;
    // implement getter/setter for userTable

    public void deleteLinkClicked(ActionEvent event) {
        User user = (User)userTable.getRowData();
        // implement code to delete user
    }
}