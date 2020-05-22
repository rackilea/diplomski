jSplitPane1.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                // use evt.getSource() if needed
                jSplitPan1.setDividerLocation(location);
            }
        });