@Root(name = "request")
public class PingRequest extends PingRequestResponse { 

    public PingRequest(Ping ping) {
            this.target = ping.getTarget();
            this.packetsize = ping.getPacketsize();
            this.timeout = ping.getTimeout();
            ...
}