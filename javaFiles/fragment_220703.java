final EnvironmentConfig config = new EnvironmentConfig().
            setLogDataReaderWriterProvider("jetbrains.exodus.io.WatchingFileDataReaderWriterProvider").
            setLogCacheShared(false).
            setMemoryUsagePercentage(1);
final Environment env = Environments.newInstance(dir, config);
final PersistentEntityStore store = PersistentEntityStores.newInstance(env);