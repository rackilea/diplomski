public void actionPerformed( ActionEvent e ){
    if ( e.getSource() == buttons.get(0) )
        //this line to assign the hostname to a variable so that we can use it to send the message
        String thisIP = buttons.get(0).getText();
        //now use this to send your message
    if ( e.getSource() == buttons.get(1) )
        String thisIP = buttons.get(1).getText();
        //now use this to send your message
    if ( e.getSource() == buttons.get(2) )
        String thisIP = buttons.get(2).getText();
        //now use this to send your message
    if ( e.getSource() == buttons.get(3) )
        String thisIP = buttons.get(3).getText();
        //now use this to send your message
}