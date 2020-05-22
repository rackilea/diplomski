boolean defaultLFDecorated = JDialog.isDefaultLookAndFeelDecorated();
    try {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane pane = new JOptionPane("This is a message", JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = pane.createDialog("Error");
        dialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        pane.setOpaque(false);
        ArrayList<Component> components = new ArrayList<Component>(Arrays.asList(pane.getComponents()));
        while(!components.isEmpty()) {
            Component c = components.remove(0);
            if(c instanceof JComponent) {
                ((JComponent)c).setOpaque(false);
            }

            if(c instanceof Container) {
                components.addAll(Arrays.asList(((Container)c).getComponents()));
            }
        }
        dialog.setBackground(new Color(0, 0, 0, 78));
        dialog.setVisible(true);
        dialog.dispose();
    }
    finally {
        JDialog.setDefaultLookAndFeelDecorated(defaultLFDecorated);
    }