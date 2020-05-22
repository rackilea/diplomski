final LineChart chart = new LineChart(buildDataset(mTitles, data), mRenderer);
final GraphicalView view = new GraphicalView(mContext, chart);
view.setOnClickListener(new View.OnClickListener() {
  public void onClick(View v) {
     double[] xy = chart.toScreenPoint(view.toRealPoint(0));
     int[] location = new int[] {(int) xy[0], (int) xy[1]};
     SeriesSelection seriesSelection = view.getCurrentSeriesAndPoint();
     if (seriesSelection != null) {
         final Data d = mModel.getDiaryAt(seriesSelection.getSeriesIndex(), 
         seriesSelection.getPointIndex());
         //show popup at xy[0] xy[1]
     }
  }