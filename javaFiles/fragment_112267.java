SessionReadResults sessionResults = results.await();
for (Session session : sessionReadResult.getSessions()) {
        List<DataSet> dataSets = sessionReadResult.getDataSet(session);
        for (DataSet dataSet : dataSets) {
            for (DataPoint dataPoint : dataSet.getDataPoints()) {
            // Create new IndividualSession object, add data to it then add it to arraylist
               IndividualSession individualSessionObject = new IndividualSession();
               individualSessionObject.setFromDate(new Date(session.getStartTime(TimeUnit.SECONDS)));
               individualSessionObject.setToDate(new Date(session.getEndTime(TimeUnit.SECONDS)));
            individualSessionObject.setStepCount(dataPoint.getValue(Field.FIELD_STEPS).asInt());
                    //use the results
            }
        }
    }