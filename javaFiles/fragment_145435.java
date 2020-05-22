public static void main(String[] args) throws Exception {

// Create Hadoop configuration
Configuration conf = new Configuration();

// Add 3rd-party libraries
addJarToDistributedCache("/tmp/hadoop_app/file.jar", conf);


// Create my job
Job job = new Job(conf, "Hadoop-classpath");
.../...
}