application
  .getTVService()
  .flatMap(service ->
     service
     .searchSeries(searchFor)
     .flatMapIterable(series -> series)
     .flatMap(aSeries -> 
        service
        .queryImages(aSeries.getId(), "poster")
        .map(i ->  combineSeriesData(aSeries, i))
     )
  );