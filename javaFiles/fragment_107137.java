// Create a YarnConfiguration for bootstrapping the minicluster
final YarnConfiguration bootConf = new YarnConfiguration();
// Base directory to store HDFS data in
final File hdfsBase = Files.createTempDirectory("temp-hdfs-").toFile();
bootConf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, hdfsBase.getAbsolutePath());
// Start Mini DFS cluster
final MiniDFSCluster hdfsCluster = new MiniDFSCluster.Builder(bootConf).build();
// Configure and start Mini MR YARN cluster
bootConf.setInt(YarnConfiguration.RM_SCHEDULER_MINIMUM_ALLOCATION_MB, 64);
bootConf.setClass(YarnConfiguration.RM_SCHEDULER, FifoScheduler.class, ResourceScheduler.class);
final MiniMRYarnCluster yarnCluster = new MiniMRYarnCluster("test-cluster", 1);
yarnCluster.init(bootConf);
yarnCluster.start();
// Get the "real" Configuration to use from now on
final Configuration conf = yarnCluster.getConfig();
// Get the filesystem
final FileSystem fs = new Path ("hdfs://localhost:" + hdfsCluster.getNameNodePort() + "/").getFileSystem(conf);