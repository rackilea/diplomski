protected void installRolloverBorders ( JComponent c )  {
        // Put rollover borders on buttons
        Component[] components = c.getComponents();

        for (Component component : components) {
            if (component instanceof JComponent) {
                ((JComponent) component).updateUI();
                setBorderToRollover(component);
            }
        }
    }