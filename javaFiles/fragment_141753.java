runButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        // Some code checked on some radio buttons
        if(radioButton.isSelected()) {
            if(radioButton.getText().equals("VALIDATE")) {
               Runnable runnable = new ValidateThread();
               Thread thread = new Thread(runnable);
               thread.start();
            }
        }
    }

});