public void updateFrame(MainFrame mainFrame) {
    DefaultListModel<Test> listModel = new DefaultListModel<Test>();
    for(int i = 0 ; i < this.getTestList().size() ; i++) {
        listModel.add(i, this.getTestList().get(i));
    }

    // ***** get rid of this *****
    // JList<Test> currList = new JList<>(listModel);      
    // currList.setVisible(true);
    // mainFrame.setList(currList);

    // ***** and instead simply do this *****
    mainFrame.getList().setModel(listModel);
}