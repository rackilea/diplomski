@Override
        protected void paintComponent(Graphics g) {
            if (getBorder() instanceof JRoundedCornerBorder) {
                g.setColor(getBackground());
                Shape borderShape = ((JRoundedCornerBorder) getBorder())
                    .getBorderShape(getWidth(), getHeight());
                ((Graphics2D) g).fill(borderShape);
            }
            super.paintComponent(g);
        }

        @Override
        public boolean isContentAreaFilled() {
            if (getBorder() instanceof JRoundedCornerBorder) return false;
            return super.isContentAreaFilled();
        }

        // using
        button.setOpaque(false);