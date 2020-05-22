public void designMainPanel() {
    setLayout(null); //here it's null but it's working now
    JTabbedPane tab1 = getJtpView();
    tab1.setBounds(0, 0, 650, 520); //←---fixed:set bound to child JTabbedPane 
    add(tab1);
}