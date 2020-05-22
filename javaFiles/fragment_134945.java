JPanel root = new JPanel();

JButton btn = new JButton();
JCheckBox voer = new JCheckBox("Voerbakjes");

btn.setLayoutX(50);
btn.setLayoutY(600);
voer.setLayoutX(300);
voer.setLayoutY(300);

root.getChildren().add(voer);
root.getChildren().add(btn);