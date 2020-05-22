saveFile.addActionListener(new java.awt.event.ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ClassB ss = new ClassB(); 
        try {
            ss.saveAsTable();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }   
    });