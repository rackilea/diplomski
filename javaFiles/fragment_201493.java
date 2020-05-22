button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        new Worker().execute();
    }
});