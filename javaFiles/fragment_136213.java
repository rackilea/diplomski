final Config configLocal = ConfigFactory.parseString("akka.cluster.roles = [masterRole] ").
    //  withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.port=0" )).
        withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname = \"127.0.0.1\"")).
            //withFallback(ConfigFactory.parseString("akka.cluster.role.workerRole.min-nr-of-members = " +nbWorkers)).
        withFallback(ConfigFactory.parseString("akka.cluster.seed-nodes = [\"akka.tcp://MasterMain@127.0.0.1:2552\"]")).
            withFallback(ConfigFactory.load());