public S3 individualS3BucketSize(S3 s3) {
        Instant now = Instant.now();
        Instant earlier = now.minusSeconds(259201); //3 Days in the past in seconds
        Statistic stat = Statistic.AVERAGE;
        GetMetricStatisticsResponse response;

        Dimension dimensionsName = Dimension.builder().name("BucketName").value(XXXXX).build();
        Dimension dimensionsStorage = Dimension.builder().name("StorageType").value("StandardStorage").build();

        Collection<Dimension> dimensions = new ArrayList<>();
        dimensions.add(dimensionsName);
        dimensions.add(dimensionsStorage);

        GetMetricStatisticsRequest request = GetMetricStatisticsRequest.builder().namespace(namespace).metricName("BucketSizeBytes")
            .dimensions(dimensions)
            .startTime(earlier).endTime(now).period(3600)
            .unit("Bytes").statistics(stat).build();

        response = cwClient.getMetricStatistics(request);
        System.out.println(response.toString());
        return null;
    }