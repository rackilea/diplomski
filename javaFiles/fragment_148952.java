this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                View.this.requestFocusInWindow();
            }            
        });