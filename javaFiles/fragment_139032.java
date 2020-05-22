JButton launchMyApp = new JButton("launch");
launchMyApp.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        String[] args = {};
        Application.launch(MyApp.class, args);
    }
});