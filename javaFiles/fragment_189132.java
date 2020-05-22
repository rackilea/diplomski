final Image img = ...;
        ComponentListener cl = new ComponentAdapter() {
            public void componentResized(ComponentEvent ce) {
                Component c = ce.getComponent();
                img = im1.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH); 
            }
        };