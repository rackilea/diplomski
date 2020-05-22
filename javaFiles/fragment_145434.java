private static void addJarToDistributedCache(
    String jarPath, Configuration conf)
throws IOException {


File jarFile = new File(jarPath);

// Declare new HDFS location
Path hdfsJar = new Path(jarFile.getName());

// Mount HDFS
FileSystem hdfs = FileSystem.get(conf);

// Copy (override) jar file to HDFS
hdfs.copyFromLocalFile(false, true,
    new Path(jar), hdfsJar);

// Add jar to distributed classPath
DistributedCache.addFileToClassPath(hdfsJar, conf);
}