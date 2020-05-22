ShapeListener test = new ShapeListener(); // First instance
JButton button = new JButton("Hello");
test.setBackground(Color.CYAN);
button.addActionListener(new ShapeListener()); // Second instance...
test.add(button);
add(test);