SwingWorker<Void, XYSeries> worker = new SwingWorker<Void, XYSeries>() {

   @Override
   protected Void doInBackground() throws Exception {
       /* 
        * This part is extracted from your multiPlot() method
        * I've just reduced the scale factor and get rid of double arrays
        */
       int numberOfElements = 100; // this is the number of elementes in X axis    
       for(int y = 0; y < 12; y++) { // we want 12 series

           XYSeries series = new XYSeries("Plot " + y);
           for (int x = 0; x < numberOfElements; x++) {
               series.add(x, y*10); //add x,y point
           }
           publish(series);
           Thread.sleep(100);// just for animation purpose
       }
       return null;              
   }

   @Override
   protected void process(List<XYSeries> chunks) {
       for(XYSeries series : chunks){
           /* 
            * Add the series to the "model" here.
            * It will notify the "view" data has been changed and this last one will be updated
            * It's important make this call here to ensure the "view" is updated in the EDT.
            */
           xySeriesCollection.addSeries(series);
       }
   }
};