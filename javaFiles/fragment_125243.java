if(event.getSource()== enter){//getSource = where the event occurred 
    JOptionPane.showMessageDialog(null, "Hello");
    // You can reference "cl", which suggests that the program
    // can compile, meaning the "cl" must be declared some where
    // and based on the method you are accessing, is probably
    // a CardLayout...which hasn't being initialised...
    cl.show(setPanel, "MainMenu"); <-----here is the problem