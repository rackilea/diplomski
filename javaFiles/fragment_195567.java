....
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        secondClass = new SecondClass(textArea);
        secondClass.printOnTextArea();
    }
});
....