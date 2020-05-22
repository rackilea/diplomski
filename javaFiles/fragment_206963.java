MigLayout layout = new MigLayout("fillx, debug");
JPanel content = new JPanel(layout);

JLabel label = new JLabel("Warehouse");
label.setFont(label.getFont().deriveFont(Font.BOLD | Font.ITALIC, 18));

CC componentConstraints = new CC();
componentConstraints.alignX("center").spanX();
content.add(label, componentConstraints);