public void readWriteZipContents(String zipLoc,String hdfsBasePath){
    JavaSparkContext jsc = new JavaSparkContext(new SparkContext(new SparkConf()));
    JavaPairRDD<String, PortableDataStream> zipFilesRdd = jsc.binaryFiles(zipLoc);
    zipFilesRdd.collect().forEach(file -> {
        ZipInputStream zipStream = new ZipInputStream(file._2.open());
        ZipEntry zipEntry = null;
        Scanner sc = new Scanner(zipStream);
        try {
            while ((zipEntry = zipStream.getNextEntry()) != null) {
                String entryName = zipEntry.getName();
                if (!zipEntry.isDirectory()) {
                    //create the path in hdfs and write its contents
                   Configuration configuration = new Configuration();
                    configuration.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
                    configuration.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
                    FileSystem fs = FileSystem.get(URI.create("hdfs://localhost:8020"), configuration);
                    FSDataOutputStream hdfsfile = fs.create(new Path(hdfsBasePath + "/" + entryName));
                   while(sc.hasNextLine()){
                       hdfsfile.writeBytes(sc.nextLine());
                   }
                   hdfsfile.close();
                   hdfsfile.flush();
                }
                zipStream.closeEntry();
            }
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sc.close();
        //return fileNames.iterator();
    });
}