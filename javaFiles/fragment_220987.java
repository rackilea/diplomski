JButton btnContinue = new JButton("Continue");
btnContinue.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       String field1 = txtrEnterYourFull.getText();
       String name = nameL.getText();
       String field2 = txtroptionalEnterYour.getText();

       Display display = new Display(name, field1, field2);//using this as example
}

}