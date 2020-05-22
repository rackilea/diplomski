master {
    akka {
        actor {
            provider = "akka.remote.RemoteActorRefProvider"
        }
        remote {
            transport = "akka.remote.netty.NettyRemoteTransport"
            netty {
                hostname = "your-master-host-name"
                port = 0
            }
        }
    }
}