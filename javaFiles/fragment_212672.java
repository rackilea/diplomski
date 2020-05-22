setLayout(new BorderLayout());
    add(new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(5, 5, 105, 105);
        }
    }, BorderLayout.CENTER);