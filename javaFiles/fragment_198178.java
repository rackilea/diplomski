public AdderTester() {
    initComponents();
    checker.getAdder().randomize();
    num1Label.setText(Integer.toString(checker.getAdder().int1));
    num2Label.setText(Integer.toString(checker.getAdder().int2));
    opLabel.setText(checker.getAdder().operator);
}