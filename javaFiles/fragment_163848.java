Scan scan = new Scan();
scan.setTimeRange( lowerBound, upperBound );

 Call it for each Column
scan.addColumn //

scan.setCaching( 1000 ) // how many rows for caching that will be passed to scanners.
ResultScanner scanner = table.getScanner( scan );
Iterator< Result > iterator = scanner.iterator();