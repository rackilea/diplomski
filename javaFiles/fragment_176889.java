public double first;
public double sum;

private void method() {
    JTextField field = new JTextField();
    JButton plus = new JButton("+");
    plus.addActionListener(e -> {
        first = Double.parseDouble(field.getText());
    });

    JButton result = new JButton("=");
    result.addActionListener(e -> {
        sum = first + Double.parseDouble(field.getText());
    });
}