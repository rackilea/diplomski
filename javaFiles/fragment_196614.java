start.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        String shost = host.getText();
        String suser = user.getText();
        String spass = pass.getText();
        String sportb = port.getText();
        int sport = Integer.parseInt(sportb);

        SSHTask task = new SSTask(shost, suser, spass, sport);
        Thread thread = new Thread(task);
        thread.start();
    }
});