ml = new MouseListener() {
    @Override
    public void mousePressed(MouseEvent e) {
        dispatchEvent(e);
    }
    // same for all methods
    // ....

    private void dispatchEvent(MouseEvent e) {
        if (isBlocked)
            return;
        Point glassPanePoint = e.getPoint();
        Container container = frame.getContentPane();
        Point containerPoint = SwingUtilities.convertPoint(glass,
                glassPanePoint, container);

        if (containerPoint.y < 0) { // we're not in the content pane
            // Could have special code to handle mouse events over
            // the menu bar or non-system window decorations, such as
            // the ones provided by the Java look and feel.
        } else {
            // The mouse event is probably over the content pane.
            // Find out exactly which component it's over.
            Component component = SwingUtilities.getDeepestComponentAt(
                    container, containerPoint.x, containerPoint.y);

            if (component != null) {
                // Forward events to component below
                Point componentPoint = SwingUtilities.convertPoint(
                        glass, glassPanePoint, component);
                component.dispatchEvent(new MouseEvent(component, e
                        .getID(), e.getWhen(), e.getModifiers(),
                        componentPoint.x, componentPoint.y, e
                                .getClickCount(), e.isPopupTrigger()));
            }
        }
    }
};

glass.addMouseListener(ml);
glassButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        if (isBlocked) {
            // glass.removeMouseListener(ml);
            glassButton.setText("Block");
        } else {
            // ml = new MouseAdapter() { };
            // glass.addMouseListener(ml);
            glassButton.setText("Unblock");
        }

        isBlocked = !isBlocked;
    }
});