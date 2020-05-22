public void actionPerformed(ActionEvent e) {
    if ((e.getActionCommand()).equals("spam1")) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Spambot.Start("data/firstfile.txt");
                } catch (FileNotFoundException | InvocationTargetException | 
                        AWTException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
    }
    // ... rest of conditions

}