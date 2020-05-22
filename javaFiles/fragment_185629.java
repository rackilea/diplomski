addMouseWheelListener(new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() > 0) {
                clickArrowButton("scrollTabsBackwardAction");
            } else {
                clickArrowButton("scrollTabsForwardAction");
            }
        }
    });