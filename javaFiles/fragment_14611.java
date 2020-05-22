// essentially the "frame" around the 
    // new window you will draw the GUI inside of
    JFrame frame = new JFrame();
    int width = 400, height = 400;
    frame.setSize(width + 40, height + 60);

    int cellWidth = width / cols;
    int cellHeight = height / rows;

    // The panel, which is the surface you will draw on
    JPanel panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.translate(15, 10);
            g.setColor(Color.black);
            // drawing universo
            // drawing vertical lines (column borders)
            for(int i = 0; i <= cols; i++) {
                int dx = (int)(i * width / (double)cols);
                g.drawLine(dx, 0, dx, height);
            }
            // drawing horizontal lines (row borders)
            for(int i = 0; i <= rows; i++) {
                int dy = (int)(i * height / (double)rows);
                g.drawLine(0, dy, width, dy);
            }
            // draw all your Person objects
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    // optionally pass cellWidth and cellHeight to help
                    // draw the Person object in the correct cell.
                    if(universo[i][j] != null) {
                        universo[i][j].draw(g, cellWidth, cellHeight);
                    }
                }
            }
        }
    };

    // Place the panel inside of the frame
    frame.add(panel);

    // make the frame and its contents visible on the screen
    frame.setVisible(true);