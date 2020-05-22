import de.flapdoodle.embed.mongo.config.ArtifactStoreBuilder;

    ...
    MongodStarter starter = MongodStarter.getDefaultInstance();

    String bindIp = "localhost";
    int port = 12345;
    IMongodConfig mongodConfig = new MongodConfigBuilder()
        .version(Version.Main.PRODUCTION)
        .net(new Net(bindIp, port, Network.localhostIsIPv6()))
        .build();

    MongodExecutable mongodExecutable = null;