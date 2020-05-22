JComponent     title = ((BasicInternalFrameUI)myInternalFrame.getUI()).getNorthPane();
    for (int i = 0; i < title.getComponentCount(); i++) {
        JComponent component = (JComponent)title.getComponent(i);
        if(component instanceof JButton) {
            JButton button = ((JButton)component);
            if(button.getName() == null) continue;
            if(button.getName().endsWith("closeButton")) {
                button.setIcon(myIcon);
                button.setSelectedIcon(myIcon);
                button.setPressedIcon(myIcon);
            }
            if(button.getName().endsWith("maximizeButton")) {
                ...
            }
            if(button.getName().endsWith("iconifyButton")) {
                ...
            }
        }
    }