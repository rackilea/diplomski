if (pump1Running){
            jLabel3.setIcon(new ImageIcon(getClass().getResource("/Pauze.png")));
            jLabel3.setText("Infusion Paused");
            jButton1.setText("Start Infusion");
            pump1Running = !pump1Running;
        }
        else {//if (pump1Running == true){
            jLabel3.setIcon(new ImageIcon(getClass().getResource("/Pauze.png")));
            jLabel3.setText("Running infusion");
            jButton1.setText("Stop Infusion");
            pump1Running = !pump1Running;
        }