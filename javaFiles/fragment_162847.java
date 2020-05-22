JLabel label = new JLabel("Password") {
    @Override public Dimension getMaximumSize() {
        return super.getPreferredSize();
    }
};
JPasswordField field = new JPasswordField() {
    @Override public Dimension getMaximumSize() {
        return super.getPreferredSize();
    }
};
field.setColumns(10);
Box verticalBox = Box.createVerticalBox();
verticalBox.add(Box.createVerticalGlue());
verticalBox.add(label);
verticalBox.add(field);
verticalBox.add(Box.createVerticalGlue());
//
Box horizontalBox = Box.createHorizontalBox();
horizontalBox.add(Box.createHorizontalGlue());
horizontalBox.add(verticalBox);
horizontalBox.add(Box.createHorizontalGlue());
add(horizontalBox);