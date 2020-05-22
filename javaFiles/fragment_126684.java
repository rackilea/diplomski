final BasicStroke dashedStroke = new BasicStroke(
                  2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                  1.0f, new float[] {6.0f, 6.0f}, 0.0f);
     XYLineAndShapeRenderer render = new XYLineAndShapeRenderer() {
        @Override
        public Stroke getItemStroke(int row, int column) {
            if (column < dashedThreshold) {
                return lookupSeriesStroke(row);
            } else {
               return dashedStroke;
            }
       };