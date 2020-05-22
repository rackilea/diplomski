final hdfsNameNodePath = "hdfs://quickstart.cloudera:8080";

JavaPairRDD<String, PortableDataStream> imageByteRDD = jsc.binaryFiles(sourcePath);
        if(!imageByteRDD.isEmpty())
            imageByteRDD.foreachPartition(new VoidFunction<Iterator<Tuple2<String,PortableDataStream>>>() {

                @Override
                public void call(Iterator<Tuple2<String, PortableDataStream>> arg0)
                        throws Exception {

                    Configuration conf = new Configuration();
                    conf.set("fs.defaultFS", hdfsNameNodePath);
                    //the string above should be passed as argument
SequenceFile.Writer writer = SequenceFile.createWriter(
                                     conf, 
                                     SequenceFile.Writer.file([***ETCETERA...