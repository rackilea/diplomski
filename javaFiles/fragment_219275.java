ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (evt instanceof JButton) {
            currentLetter = ((JButton) src).getText();
            // do something with letter
        } // else something seriously wrong
    }
};