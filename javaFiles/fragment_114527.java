bouton1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                 CreerModelJCL();
            }
        }).start();
        JOptionPane.showMessageDialog(fenetre, "Modelisation JCL Fini");
    }
});