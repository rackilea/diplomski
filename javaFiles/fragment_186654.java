jb.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        go = !go;
        if (go) {
            jb.setText("Stop!");
            Thread t = new Thread(new MouseRunner());
            t.start();
        } else {
            jb.setText("Start!");
        }
    }
});