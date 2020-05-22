List<Metric> smq = sonar.findAll(MetricQuery.all());
    System.out.println(smq);

    for(int i = 0; i< smq.size(); i++){
       System.out.println(smq.get(i));
    }