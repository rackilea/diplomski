JRadioButton button1 = new JRadioButton("M"),button2 = new JRadioButton(("F"));
button1.setHorizontalAlignment(SwingConstants.CENTER);  button2.setHorizontalAlignment(SwingConstants.CENTER);
ButtonGroup bgroup1 = new ButtonGroup();
bgroup1.add(button1); bgroup1.add(button2);
JPanel radiobuttonpanel = new JPanel();
BoxLayout radiobuttonpanellayout = new BoxLayout(radiobuttonpanel, BoxLayout.X_AXIS);
radiobuttonpanel.setLayout(radiobuttonpanellayout);
radiobuttonpanel.add(button1); radiobuttonpanel.add(button2);
panel4.add(radiobuttonpanel);