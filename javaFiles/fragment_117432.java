public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
    {
        String str = (value == null) ? "" : value.toString();


        if ("New Tag...".equals(str))
        {
            JButton button = new JButton(str);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
            button.setMargin(new Insets(0, 24, 0, 0));
            button.setHorizontalAlignment(SwingConstants.LEFT);
            return button;
        }