/* Create model */        
DefaultListModel<String> dlm = new DefaultListModel<>();

/* Add elements */ 
dlm.addElement("test");
dlm.addElement("test2");

/* JList to use the model */ 
JList<String> list = new JList<>(dlm);

/* Update an element */
dlm.set(1, "test3");