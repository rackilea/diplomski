JLabel lbl1 = new JLabel("nickname0");
JLabel lbl2 = new JLabel("nickname1");
...

JLabel[] inputs = {lbl1, lbl2, ...};
for(int i = 0; i < inputs.length; i++) {
    inputs[i].setText("exemple" + i);
}