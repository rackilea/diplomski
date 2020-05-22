JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setBackground(Color.YELLOW);
        panel.add(new JLabel("I am message Label"));
        panel.add(new JButton("CLOSE"));
        JPanel glassPanel = new JPanel(new GridBagLayout());
        glassPanel.setOpaque(false);
        glassPanel.add(panel);