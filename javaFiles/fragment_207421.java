Box box = Box.createHorizontalBox();
box.add(new JLabel("Text 1"));
JLabel image = new JLabel();
image.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
box.add(image);
box.add(new JLabel("Text 2"));