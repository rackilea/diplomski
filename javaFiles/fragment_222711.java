...
  @Deprecated
  public Job() throws IOException {
    this(new Configuration());
  }

  @Deprecated
  public Job(Configuration conf) throws IOException {
    this(new Cluster(conf), conf);
  }

  @Deprecated
  public Job(Configuration conf, String jobName) throws IOException {
    this(conf);
    setJobName(jobName);
  }

  Job(Cluster cluster) throws IOException {
    this(cluster, new Configuration());
  }

  Job(Cluster cluster, Configuration conf) throws IOException {
    super(conf, null);
    this.cluster = cluster;
  }

  ...
  public static Job getInstance(Cluster cluster, Configuration conf) 
      throws IOException {
    return new Job(cluster, conf);
  }