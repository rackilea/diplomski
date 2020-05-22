// DO NOT - a opaque component violates its contract, as it will not fill
 // its complete area  
        @Override
        protected void paintComponent(Graphics g) {
            if (getBorder() instanceof JRoundedCornerBorder) {
                Shape borderShape = ((JRoundedCornerBorder) getBorder()).
                    getBorderShape(getWidth(), getHeight());
                g.setClip(borderShape);
            }
            super.paintComponent(g);
        }