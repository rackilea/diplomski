btnSend.addActionListener(new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String fileContents;
        a = System.currentTimeMillis();
        try {
            fileContents = control.getFileContents(txtSearch.getText());
            b = System.currentTimeMillis();
            txtView.setText(fileContents + "\n" + "\n" + "The process took "+(b-a)+"milliseconds to execute." + "\n" + "("+((b-a)/1000)+" seconds)");

        } catch (RemoteException e) {
            txtView.setText("File not found");
        }

    }