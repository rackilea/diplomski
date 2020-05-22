Value value = new Value().setIntVal(Integer.valueOf(steps));
    List<Value> values = Arrays.asList(value);

    DataPoint point = new DataPoint()
                            .setValue(values)
                            .setDataTypeName(DT_STEPS)
                            .setStartTimeNanos(startNS)
                            .setEndTimeNanos(endNS);

    List<DataPoint> dataPoints = Arrays.asList(point);

    String datasetId = startNS + "-" endNS;

    Dataset content = new Dataset()
                            .setDataSourceId(dataSourceId)
                            .setPoint(dataPoints)
                            .setMinStartTimeNs(startNS)
                            .setMaxEndTimeNs(endNS);

    Fitness.Users.DataSources.Datasets.Patch request = 
           service.users().dataSources().datasets().patch(
                "me", 
                dataSourceId, 
                datasetId, 
                content);

    Dataset ds = request.execute();