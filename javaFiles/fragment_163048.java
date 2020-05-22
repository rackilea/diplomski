verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));    
panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
panel.add(Box.createHorizontalGlue());
panel.add(label);
panel.add(Box.createHorizontalGlue());
verticalPanel.add(panel);