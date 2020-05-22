raphView graph = (GraphView) findViewById(R.id.graph);
LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {

//just for 3 datasets
              new DataPoint(0,mylist.get(0)),
               new DataPoint(1,mylist.get(1)),
               new DataPoint(2,mylist.get(2))
        });
graph.addSeries(series);