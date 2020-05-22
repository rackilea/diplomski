DataPoint[] values = new DataPoint[Profit.length];
for(int i =0; i<Profit.length; i++){
    Date date = getDate()[i];
    DataPoint v = new DataPoint(date, Profit[i]);
    //EDIT::
    DataPoint v = new DataPoint(Dates.get(i), Profit[i]);

    values[i] = v;

}

LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(values);
graph.addSeries(series);