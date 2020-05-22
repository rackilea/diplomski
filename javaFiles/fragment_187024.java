public void actionPerformed(ActionEvent e) {
    if (e.getSource() == inputTextField) {

        String j = inputTextField.getText();
        // run("abcdef");
        new Thread(new Runnable(){
            @Override
            public void run() {
                int length = j.length();
                int i = 0;
                while (true) {
                    if (output[0] != null) {
                        output[0].setText(j.substring(i, i + 1));
                    } else {
                        output[0].setText("");
                    }
                    i = i + 1;
                    if(i > length - 1)
                        i = 0;                                              
                    try {
                        Thread.sleep(500); // your delay in ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                       
                    shift();                        
                }               
            }           
        }).start();
    }
}