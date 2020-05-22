for(int i=0;i<81;i++){
    collection.add(new DataSet( 5, new DataUpdater_xjal() {
        double _lastUpdateX = Double.NaN;
        @Override
        public void update( DataSet _d ) {
          if ( time() == _lastUpdateX ) { return; }
          _d.add( time(), 0 );
          _lastUpdateX = time();
        }
        @Override
        public double getDataXValue() {
          return time();
        }
      } )
  );
}