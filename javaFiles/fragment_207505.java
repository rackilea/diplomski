public synchronized List<Pair<Long, Long>> 
getScores(Calendar start, Calendar finish, int maxUniqueScoreEntries) 
throws IOException 
{
  List<Pair<Long, Long>> retVal = new ArrayList<>(maxUniqueScoreEntries);
  try
  {
    long startTimeMs = start.getTimeInMillis();
    long finishTimeMs = finish.getTimeInMillis();

    Pair<Long, Long> firstVal = new Pair<Long, Long>(start.getTimeInMillis(), 0L);
    retVal.add(firstVal);

    SearchRequestBuilder srb = client.prepareSearch()
      .setIndices(solutionName)
      .setTypes(ThreadMgrWebSocketsSvc.Subprotocols.SET_APPS.toString())
    .setQuery(QueryBuilders.rangeQuery("time").from(startTimeMs).to(finishTimeMs))
    .addAggregation(
            AggregationBuilders.histogram("time_hist").minDocCount(0).field("time").order(Order.COUNT_ASC)
              .extendedBounds(startTimeMs, finishTimeMs)
              .interval((finishTimeMs - startTimeMs) / maxUniqueScoreEntries)
              .subAggregation(
                AggregationBuilders.terms("max_time")
                .field("time")
                .order(Terms.Order.aggregation("max_score", false))
                .size(1)
                .subAggregation(
                  AggregationBuilders.max("max_score").field("score"))
              )
          );

      SearchResponse sr = srb.execute().actionGet();

      Histogram timeHist = sr.getAggregations().get("time_hist");
      List<? extends Bucket> timeHistBuckets = timeHist.getBuckets();
      for (int i = 0, len = timeHistBuckets.size(); i < len; i++)
      {
        Long epochTime = null;
        Long maxScore = null;

        Histogram.Bucket maxScoreBucket = timeHistBuckets.get(i);

        Terms maxTimeTermAgg = maxScoreBucket.getAggregations().get("max_time");

        List<Terms.Bucket> buckets = maxTimeTermAgg.getBuckets();

        for (int j = 0, jlen = buckets.size(); j < jlen; j++)
        {
          Terms.Bucket bucket = buckets.get(j);

          epochTime = bucket.getKeyAsNumber().longValue();
          Aggregation agg = bucket.getAggregations().get("max_score");

          if (agg instanceof Max)
          {
            double value = ((Max) agg).getValue();
            if (value > 0)
            {
              maxScore = (long) ((value > 0) ? value : 0);
            }

          }

        }

        if (epochTime != null && maxScore != null)
        {
          System.out.printf(" %d - Date = %s; rawTime = %d ; val = %d\n", i, new DateTime(epochTime).toString(),
          epochTime, maxScore);

          Pair<Long, Long> val = new Pair<>(epochTime, maxScore);
          retVal.add(val);

        }

      }


    System.out.printf("query was %s, %s \n", new DateTime(startTimeMs).toString(),
      new DateTime(finishTimeMs).toString());

    Pair<Long, Long> last = retVal.get(retVal.size() - 1);
    if (last.getSecond().longValue() != finish.getTimeInMillis())
    {
      Pair<Long, Long> endVal = new Pair<Long, Long>(finish.getTimeInMillis(), 0L);
      retVal.add(endVal);
    }
  }
  catch (Exception e)
  {
    retVal.add(new Pair<Long, Long>(start.getTimeInMillis(), 0L));
    retVal.add(new Pair<Long, Long>(finish.getTimeInMillis(), 0L));

  }

  Collections.sort(retVal);



  return retVal;
}