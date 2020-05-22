private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
    String address = jTextField1.getText();  
    Socket sock = null;
    try {
        InetAddress addr;
        sock = new Socket(address, 80);
        addr = sock.getInetAddress();
        sock.close();
        jLabel2.setText("Status: Online"); 
    } catch (IOException ex) {
         jLabel2.setText("Status: Offline");
    }      
}