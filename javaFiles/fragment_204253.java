Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // can't access text
        sc = text.getText();
        char ch = sc.charAt(0);
        findAndReplace(s, AnswerKey, input, ch);
    }
});