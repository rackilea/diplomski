// supply this as input
    String uri = args[0];

    // reading in from hdfs
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(uri), conf);
    FSDataInputStream in = null;


    // create arraylist for hdfs file to flow into
    List<String> list = new ArrayList<String>(); // Initialize List


    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    OutputStream os = new DataOutputStream(baos);


    try
    {

        in = fs.open(new Path(uri));
        // The way:
        IOUtils.copyBytes(in, os, 4096, false);

    }
    finally{
        IOUtils.closeStream(in);
    }

    byte[] data = baos.toByteArray();
    String dataAsString = new String(data, "UTF-8"); // or whatever encoding 

    System.out.println(dataAsString);