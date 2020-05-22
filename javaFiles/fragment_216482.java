public ManagerMenu(Warehouse objTarget) {
    staffList = objTarget;
    listModel = new DefaultListModel();
    System.out.print(staffList);
    refreshListModel();
    initComponents();
}