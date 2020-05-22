public Calculator() {

    //Constructor comes here 
    button0 = new JButton("0");
    button0.addActionListener(mNumberButtonActionListener);
    // other buttons ...

    buttonDot = new JButton(".");
    buttonDot.addActionListener(mDotButtonActionListener);
    text = new JTextArea(1, 20);
}

private ActionListener mNumberButtonActionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int numberToAppend = getButtonNumber(e.getSource());
        if (isNextDigitAfterDecimalPoint()) {
            text.append(Integer.toString(numberToAppend))
        } else {
            String currentNumberText = text.getText()
            if (currentNumberText.size() == 0 || !currentNumberText.get(0).equals("0")) {
                text.append(Integer.toString(numberToAppend));
            }
        }
    }
}

private boolean isNextDigitAfterDecimalPoint() { ... }

private int getButtonNumber(JButton button) { ... }

private ActionListener mDotButtonActionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (isNextDigitAfterDecimalPoint()) {
            text.append(".");
        }
    }
}