AWSCredentials credentials = new BasicAWSCredentials(
            "whatever",
            "whatever");

    File f = new File("/home/myuser/test");

    TransferManager transferManager  = new TransferManager(credentials);

    //+upload from HDFS to S3
    Configuration conf = new Configuration();
    // set the hadoop config files
    conf.addResource(new Path("/etc/hadoop/conf/core-site.xml"));
    conf.addResource(new Path("/etc/hadoop/conf/hdfs-site.xml"));

    Path path = new Path("hdfs://my_ip_address/user/ubuntu/test/test.txt");
    FileSystem fs = path.getFileSystem(conf);
    FSDataInputStream inputStream = fs.open(path);
    ObjectMetadata objectMetadata =  new ObjectMetadata();
    Upload upload = transferManager.upload("xpatterns-deployment-ubuntu", "test_cu_jmen3", inputStream, objectMetadata);
    //-upload from HDFS to S3

    try {
        upload.waitForCompletion();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }