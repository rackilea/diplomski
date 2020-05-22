javax.swing.Timer timer = new Timer(300, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {    
        jtfIP.setEnabled(!Start && !autoRec);
        jtfPort.setEnabled(!Start && !autoRec);
        jtfSlaveID.setEnabled(!Start && !autoRec);
        jtfTimeout.setEnabled(!Start && !autoRec);
        jtfReqInterval.setEnabled(!Start && !autoRec);
        jCheckBox1.setEnabled(!Start && !autoRec);
        jCBReconnect.setEnabled(!Start && !autoRec);

        if (db != null) {
            if (!db.getIsOpen()) {
                jPBD.setBackground(Color.RED);
                jPBD.setForeground(Color.WHITE);
                jPBD.setText("ER");
            } else {
                jPBD.setBackground(Color.GREEN);
                jPBD.setForeground(Color.BLACK);
                jPBD.setText("OK ");
            }
        } else {
            jPBD.setBackground(Color.RED);
            jPBD.setForeground(Color.WHITE);
            jPBD.setText(" ER ");
        }


        if (autoRec){
            jbtnConnect.setText("Auto");
            if (Start && Connected) {
                jbtnConnect.setForeground(Color.BLACK);
                jbtnConnect.setBackground(Color.GREEN);
            } else {       
                jbtnConnect.setForeground(Color.WHITE);
                jbtnConnect.setBackground(Color.RED);
            }
        } else {
            if (Start) {
                jbtnConnect.setText("Disconnect");
                jbtnConnect.setForeground(Color.BLACK);
                jbtnConnect.setBackground(Color.GREEN);

            } else {
                jbtnConnect.setText("Connect");
                jbtnConnect.setForeground(Color.WHITE);
                jbtnConnect.setBackground(Color.RED);
            }
        }

        jtfErroriCitire.setText(String.valueOf(totalErrors));
    }
});
timer.start();