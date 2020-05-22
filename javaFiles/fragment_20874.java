.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        String urlto = jTextField8.getText();
        String o = (String)jTable2.getModel().getValueAt(selectedRow, 1);
        String urltoencode = (urlto+"?find="+o); 
        SimpleSwingBrowser browser = new SimpleSwingBrowser(); 
        browser.setVisible(true);
        browser.loadURL(urltoencode);