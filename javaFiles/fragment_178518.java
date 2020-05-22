public  class ListUserNames extends JPanel {

    public static DefaultListModel<String> listModel = new DefaultListModel<>();

    public ListUserNames() {

        setLayout(new FlowLayout());

        JList<String> usersJList = new JList<String>(listModel);

        usersJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // add a )Scroll Pane containing )List to frame
        JScrollPane sp = new JScrollPane(usersJList);
        sp.setSize(300, 400);
        add(sp);
    }
}