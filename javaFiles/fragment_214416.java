public ExamplePane() {
        final JPanel panel = new JPanel(new GridBagLayout());
        final JLabel message = new JLabel("<html>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello<br>Hello</html>");
        message.setPreferredSize(new Dimension(500, 50));

        final JPanel messagePanel = new JPanel();
        messagePanel.add(message);

        JScrollPane scroller = new JScrollPane(messagePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setPreferredSize(new Dimension(100, 50));

        panel.add(scroller);
        add(panel);
    }