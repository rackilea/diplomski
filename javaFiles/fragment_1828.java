public abstract class Ping {

    @Element(name = "target")
    protected String target;

    @Element(name = "packetsize")
    protected int packetSize;

    @Element(name = "timeout")
    protected int timeout;

    ...(getter/setter)
}