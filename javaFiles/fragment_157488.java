@Override
    public void actionPerformed(ActionEvent e) {
        // get icon from button
        Icon icon = greenButton.getIcon();

        // check if it's the green icon
        if (icon == greenIcon) {
            icon = darkGreenIcon;  // if so, make it the dark green icon
        } else {
            icon = greenIcon;  // if not, make it the green icon
        }
        greenButton.setIcon(icon);  // stuff it back into the button
    }