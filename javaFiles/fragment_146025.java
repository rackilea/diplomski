JLabel redLabel, blueLabel, greenLabel;
    redLabel = new JLabel("Red");
    redLabel.setForeground(Color.RED);
    greenLabel = new JLabel("Green");
    greenLabel.setForeground(Color.GREEN);
    blueLabel = new JLabel("Blue");
    blueLabel.setForeground(Color.BLUE);

    mainPanel.add(new JLabel("Height"));
    mainPanel.add(height, BorderLayout.CENTER);
    mainPanel.add(new JLabel("Width"));
    mainPanel.add(width, BorderLayout.CENTER);
    mainPanel.add(redLabel);
    mainPanel.add(red, BorderLayout.CENTER);
    mainPanel.add(greenLabel);
    mainPanel.add(green, BorderLayout.CENTER);
    mainPanel.add(blueLabel);
    mainPanel.add(blue, BorderLayout.CENTER);