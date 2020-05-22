private void textField(JLabel label, JTextField field) {
    GroupLayout gl = new GroupLayout(this);
    setLayout(gl);

    field.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));  // <-- ADDITION

    gl.setAutoCreateContainerGaps(true);

    gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(label)
            .addComponent(field)
    );

    gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(label)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(field)
    );
}