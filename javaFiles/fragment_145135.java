xyPlot.setRenderer(new XYLineAndShapeRenderer(false, true) {

        @Override
        public Shape getItemShape(int row, int col) {
            if (row == 0 & col == N) {
                return ShapeUtilities.createDiagonalCross(5, 2);
            } else {
                return super.getItemShape(row, col);
            }
        }
    });