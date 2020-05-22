frame.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            panel.setMaximumDrawHeight(e.getComponent().getHeight());
            panel.setMaximumDrawWidth(e.getComponent().getWidth());
            panel.setMinimumDrawWidth(e.getComponent().getWidth());
            panel.setMinimumDrawHeight(e.getComponent().getHeight());
        }
    });