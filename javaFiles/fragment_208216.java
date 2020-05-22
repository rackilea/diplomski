public void addData(final String seriesName, final double y) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            XYSeries xys = dataset.getSeries(seriesName);
            int x = 0;
            if (xys != null) {
                if (xys.getItemCount() >= xys.getMaximumItemCount()) {
                    List<XYDataItem> items = xys.getItems();
                    double[] ys = new double[items.size() - scroll];
                    for (int i = 0; i < ys.length; i++) {
                        ys[i] = items.get(i + scroll).getYValue();
                    }
                    xys.delete(0, xys.getItemCount() - 1);
                    for (int i = 0; i < ys.length; i++) {
                        xys.add(new XYDataItem(i, ys[i]));
                    }
                }
                x = xys.getItemCount();
                xys.add(new XYDataItem(x, y));
            }
        }
    });
}