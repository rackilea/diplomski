StartImagePanel contentPanel = new StartImagePanel(RollrackLogo);
setContentPane(contentPanel);

...

out.println("adding JLWelcome");
JLWelcome.setText("Welcome to Rollrack, " + namewindow.name);
contentPanel.add(JLWelcome);
JLWelcome.setVisible(true);
out.println("JLWelcome added");
out.println("adding JBRandom");
JBRandom.setText("Random");
contentPanel.add(JBRandom);
JBRandom.setVisible(true);
out.println("added JBRandom");