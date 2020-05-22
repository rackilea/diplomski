public void actionPerformed(ActionEvent a)
        {
            DefaultListModel listModel = new DefaultListModel();
            listModel.addElement(t1.getText());
            listModel.addElement(t2.getText());
            listModel.addElement(t3.getText());
            listModel.addElement(t4.getText());
            list.setModel(listModel);


        }
    });