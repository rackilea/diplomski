Configuration conf = new Configuration();
conf.addResource(new Path("/etc/hadoop/conf/core-site.xml"));
conf.addResource(new Path("/etc/hadoop/conf/hdfs-site.xml"));
FileSystem fs = FileSystem.get(conf);
fs.copyFromLocalFile(new Path("/home/cloudera/workspace/Downloader/output/data.txt"), 
                      new Path("hdfs://quickstart.cloudera:8020/user/cloudera/"));