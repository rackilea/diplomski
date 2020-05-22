public SimpleGrapher2(List<Double> scores) {
    //...
    addComponentListener(new ComponentAdapter() {

        private Timer initTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTimer.stop();
                double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (scores.size() - 1);
                double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

                graphPoints = new ArrayList<>();
                for (int i = 0; i < scores.size(); i++) {
                    double x1 = (double) (i * xScale + padding + labelPadding);
                    double y1 = (double) ((getMaxScore() - scores.get(i)) * yScale + padding);
                    graphPoints.add(new Point2D.Double(x1, y1));
                }
                repaint();
            }
        });

        @Override
        public void componentResized(ComponentEvent e) {
            if (graphPoints == null) {
                initTimer.restart();
            }
        }

    });

}