// By the way, static here is very, very bad idea
private static JTable tblShowAllMemb = new JTable();
private static JTable tblShowAllPlay = new JTable();
JScrollPane scrollPane = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

public ViewAll(){
    //....

    //Table Models:
    MemTableModel tblMembers = new MemTableModel();
    PlayTableModel tblPlaylist = new PlayTableModel();

    //...
    subPanel1.add(BorderLayout.SOUTH, tblShowAllMemb);

    //...
    subPanel2.add(BorderLayout.CENTER, tblShowAllPlay);