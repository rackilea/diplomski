JButton jButton1 = new JButton("Start");
jButton1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){
        threadPool.submit(new Runnable(){
            int counter = 10;
            public void run() {
                while(counter >= 0) {
                    JLabel_MistyvaleLoot.setText("Test" + (counter--));
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {

                    }
               }
            }
        });
    }
});