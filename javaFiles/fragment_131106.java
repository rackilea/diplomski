/** 
         * @inherited <p>
         */
        @Override
        protected void paintComponent(Graphics g) {
            if (!isOpaque() && getBackground().getAlpha() < 255) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            super.paintComponent(g);
        }