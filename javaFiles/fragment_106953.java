StringBuilder sb = new StringBuilder("<html>");
    for (String step : stepsArr) {
        sb.append(step).append("<br>");
    }
    JLabel stepLbl = new JLabel(sb.toString());
    stepLbl.setForeground(Color.black);
    stepLbl.setFont(new Font("Serif", Font.BOLD, 20));
    stepLbl.setBackground(Color.cyan);
    stepLbl.setBounds(100, 100, 100, 300);
    stepLbl.setMinimumSize(new Dimension(100, 300));
    mainPanel.add(stepLbl);