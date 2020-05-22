JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            if (table.getSelectedRowCount() != 0){
               // perform the deletion
            }else{
               // Throw an exception etc...
            }
        }
    });