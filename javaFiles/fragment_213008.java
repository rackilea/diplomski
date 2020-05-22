yourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourButtonActionPerformed(evt);
            }
        });


public void yourButtonActionPerformed(java.awt.event.ActionEvent evt) {
                String yourText = jTextField1.getText();
                HoltWinters tempHolt = new HoltWinters();


  tempHolt.methodToRun(yourText);
            }