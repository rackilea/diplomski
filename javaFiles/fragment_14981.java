public class HomePagePanel { // note code conventios!
    ...
    public HomePagePanel() {
        ...
        emailModel = new EmailTableModel();
        sorter = new TableRowSorter<EmailTableModel>(emailModel);
        table = new JTable(emailModel);
        ...
    }
}